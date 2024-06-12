package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {

	// input: x (controller로부터 들어온 요청)
	// output: (Respository한테 받은것을 controller한테 준다) List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {

	}

}
