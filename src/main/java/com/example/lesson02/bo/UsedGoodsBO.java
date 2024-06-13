package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {

	// Spring bean을 Autowired를 통해서 가져온다.
	@Autowired // Dependency Inject(DI): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper;

	// input: x (controller로부터 들어온 요청)
	// output: (Respository한테 받은것을 controller한테 준다) List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
//		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
//		return usedGoodsList;

		// 위의 코드와 동일
		return usedGoodsMapper.selectUsedGoodsList(); // controller에게 반환
	}

}
