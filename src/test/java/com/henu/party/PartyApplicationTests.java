package com.henu.party;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.henu.party.mapper.SectionMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyApplicationTests {
	@Autowired
	SectionMapper mapper;
	@Test
	public void contextLoads() {
		System.out.println(mapper.selectAllSection());
	}

}
