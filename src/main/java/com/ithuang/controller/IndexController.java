package com.ithuang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuang.common.Result;
import com.ithuang.entities.vo.ColumnVO;


@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping("/columns")
	@ResponseBody
	public Result getColumns() {
		List<ColumnVO> list = new ArrayList<>();
		ColumnVO c1 = new ColumnVO();
		c1.setId(1);
		c1.setName("个人账单管理");
		c1.setHref("/page/indexOne.html");
		ColumnVO c2 = new ColumnVO();
		c2.setId(2);
		c2.setName("账单类型管理");
		c2.setHref("/page/indexTwo.html");
		ColumnVO c3 = new ColumnVO();
		c3.setId(3);
		c3.setName("统计分析");
		c3.setHref("/page/indexThree.html");
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return Result.ok().put(list);
	}

}

