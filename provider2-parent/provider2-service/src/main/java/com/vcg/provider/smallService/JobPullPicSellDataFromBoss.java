package com.vcg.provider.smallService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vcg.boss.bill.model.RO.NetValueListRO;
import com.vcg.boss.bill.model.VO.NetValueListVO;
import com.vcg.boss.constant.RO.PageRO;
import com.vcg.boss.constant.VO.PageVO;
import com.vcg.boss.contract.feignClient.Boss_contractbaseClient;
import com.vcg.common.DateUtils;
import com.vcg.common.RestfulResultFactory;
import com.vcg.provider.model.ResourceSellFromBoss;
import com.vcg.provider.model.query.ResourceSellFromBossExample;
import com.vcg.provider.service.ResourceSellFromBossService;
import com.vcg.provider.util.BossDataUtil;

import ch.qos.logback.core.status.Status;


/**
 * 定时任务配置类
 *
 * @author 王威
 * 每天执行     获取每月从月初到现在的所有的销售数据
 * @create 2017年1月12日
 */
@Configuration
@EnableScheduling // 启用定时任务
public class JobPullPicSellDataFromBoss {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
	@Autowired
	private BossDataUtil bossDataUtil;
	
	@Autowired
	private ResourceSellFromBossService resourceSellFromBossService;
	
	@Value("${drewdatajob.shouldStartJob}")
	private Integer shouldStartJob;
	
//	@Autowired
//	private Boss_contractbaseClient bossContractbaseClient;
    
    

    @Scheduled(cron = "0 15 3 ? * *") //每天上午3点15分触发
    //@Scheduled(cron = "0 */5 * * * ?") 
    
    public void scheduler() throws ParseException {
         logger.info("updating data of current month... ");
 
         if(shouldStartJob==0){
        	 return;
         }
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
		 String sellmonth = formatter.format(DateUtils.getNowDate());
		 bossDataUtil.deleteLastMonthAll(sellmonth);//删除明细表里本月所有数据
		 String date_start_str = DateUtils.getMonthBegin(DateUtils.getNowDate());
		 String date_end_str = DateUtils.getMonthEnd(DateUtils.getNowDate());
		 formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 java.util.Date date_start=formatter.parse(date_start_str);
		 java.util.Date date_end=formatter.parse(date_end_str);
  
			 
			 
			 
		 ResourceSellFromBossExample example=new ResourceSellFromBossExample();
		 example.createCriteria().andOutbillDateBetween(date_start, date_end);
		 
		 Integer counts  = this.resourceSellFromBossService.countByExample(example);
		 double temp= (double)counts / bossDataUtil.pagesize;
		 Integer pages   =   (int) Math.ceil(temp);
		 List<ResourceSellFromBoss> list =null;
	 
			try {
				if(pages>=1){
					for(int pageNum =1;pageNum<=pages;pageNum++){//第一页已经有了 从第二页开始
						 PageHelper.startPage(pageNum, bossDataUtil.pagesize);
						  list = this.resourceSellFromBossService.selectByExample(example);
	                     bossDataUtil.insertBossDataMulti(list);
					}
					//更新这个月的总计数据
					if(pages>0){
						bossDataUtil.updateSellSumMonth(sellmonth);
					}
					
				}
				 logger.info("job更新"+counts+"条本月数据");
		 		        
		     } catch (Exception e) {
		       e.printStackTrace(); 
		       logger.info("job报错,本月数据丢失");
		        
		     } 
		 
	   
			
	 
        }
    
}