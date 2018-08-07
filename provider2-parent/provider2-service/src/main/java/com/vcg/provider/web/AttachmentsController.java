package com.vcg.provider.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vcg.provider.model.Attachments;
import com.vcg.provider.model.query.AttachmentsExample;
import com.vcg.provider.service.AttachmentsService;

@RestController
@RequestMapping("/attachments")
public class AttachmentsController {

	@Autowired
	private AttachmentsService attachmentsService;
	
	@RequestMapping(value="/pageList",method={RequestMethod.GET,RequestMethod.POST})
	public Object pageList(@RequestBody(required=false) Attachments attachments,@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="10") int pageSize,HttpServletRequest request){
		
		AttachmentsExample example=new AttachmentsExample();
		
		//TODO Attachments 与 example关联
		
		
		PageHelper.startPage(pageNum, pageSize);
		List<Attachments> lst = this.attachmentsService.selectByExample(example);
		return  new PageInfo<Attachments>(lst);
	}
	
	
	@RequestMapping(value="/list",method={RequestMethod.GET,RequestMethod.POST})
	public Object list(@RequestBody(required=false) Attachments attachments){
		
		AttachmentsExample example=new AttachmentsExample();
		//TODO Attachments 与 example关联
		
		
		List<Attachments> lst = this.attachmentsService.selectByExample(example);
		return  lst;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Object create(@RequestBody Attachments attachments){
		
		return this.attachmentsService.insertSelective(attachments);
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Object update(@RequestBody Attachments attachments){
		
		return this.attachmentsService.updateByPrimaryKeySelective(attachments);
		
	}
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public Object view(@RequestParam Integer id){
		
		return this.attachmentsService.selectByPrimaryKey(id);
		
	}
	

	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Object delete(@RequestBody Map<String,Integer> ids){
		
		return this.attachmentsService.deleteByPrimaryKey(ids.get("id"));
		
	}
	
//	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
//	public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile){
//		
//		String fileName = uploadFile.getOriginalFilename();
//		String directory = env.getProperty("custom.uploadFile");
//		String filePath = Paths.get(directory, fileName).toString();
//		try {
//			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//			stream.write(uploadFile.getBytes());
//			stream.flush();
//			stream.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
