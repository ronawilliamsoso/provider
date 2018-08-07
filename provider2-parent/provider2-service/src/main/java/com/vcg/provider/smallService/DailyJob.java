package com.vcg.provider.smallService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.vcg.boss.bill.model.RO.NetValueListRO;
import com.vcg.boss.bill.model.VO.NetValueListVO;
import com.vcg.boss.constant.RO.PageRO;
import com.vcg.boss.constant.VO.PageVO;
import com.vcg.boss.contract.feignClient.Boss_contractbaseClient;
import com.vcg.provider.model.Contract;
import com.vcg.provider.model.query.ContractExample;
import com.vcg.provider.service.ContractService;
import com.vcg.provider.util.BossDataUtil;
import com.vcg.common.DateUtils;

/**
 * 定时任务配置类
 *
 * @author 王威
 * 每天执行的小任务
 * @create 2017年1月12日
 */
@Configuration
@EnableScheduling // 启用定时任务
public class DailyJob {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
	@Autowired
	private BossDataUtil bossDataUtil;
	
	@Autowired
	private ContractService contractService;
    
    

    @Scheduled(cron = "0 0 22 * * ?") 
    //@Scheduled(cron = "0 */5 * * * ?") 
    
    public void scheduler() throws ParseException {
         logger.info("update contract leftdays ");
 
		
			ContractExample exam = new ContractExample();
			exam.createCriteria().andContractStatusEqualTo(1);
			List<Contract> contracts = this.contractService.selectByExample(exam);
			
		 
			if(contracts.size()>0){
				for(Contract contract : contracts){
					if(contract.getEndDate()!=null){
						 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						 String today = formatter.format(DateUtils.getNowDate());
						 String contractEndDay = formatter.format(contract.getEndDate());
						 if(today.equals(contractEndDay)){
							 Contract update = new Contract();
							 update.setId(contract.getId());
							 update.setContractStatus(0);
							 update.setLeftDays(0);
							 contractService.updateByPrimaryKeySelective(update);
							 
						 }else{
								int days  = DateUtils.daysBetween(DateUtils.getNowDate(), contract.getEndDate()); 
								if(days>0){
									 Contract update = new Contract();
									 update.setId(contract.getId());
									 update.setLeftDays(days);
									 contractService.updateByPrimaryKeySelective(update);
								}else{
									 Contract update = new Contract();
									 update.setId(contract.getId());
									 update.setLeftDays(0);
									 update.setContractStatus(0);
									 contractService.updateByPrimaryKeySelective(update);
								}
						 }
					}
				}
				 
			}
			
			logger.info("完成更新contract_status 和left_days字段");
			
	 
        }
    
}