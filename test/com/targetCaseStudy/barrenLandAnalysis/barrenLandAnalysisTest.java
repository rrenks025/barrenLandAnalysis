package com.targetCaseStudy.barrenLandAnalysis;

import static org.junit.Assert.*;

import org.junit.Test;
import com.targetCaseStudy.barrenLandAnalysis.Land;

public class barrenLandAnalysisTest {
	Land myLand;
	
	@Test
	public void test1() {
		String testString = "{\"0 292 399 307\"}"; 
		String expectedResult = "116800 116800 ";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}
	
	@Test
	public void test2() {
		String testString = "{\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"}"; 
		String expectedResult = "22816 192608 ";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}

	@Test
	public void test3() {
		String testString = "{\"0 50 59 69\", \"30 70 59 129\", \"0 130 99 159\", \"90 90 399 119\", \"130 120 159 159\", \"180 120 209 179\", \"0 180 239 229\", \"180 230 279 599\", \"280 530 399 559\"}"; 
		String expectedResult = "1800 4800 40500 55400 66600 ";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}
	
	@Test
	public void test4() {
		String testString = "{\"0 50 349 99\", \"50 150 399 199\", \"0 250 349 299\", \"0 350 399 359\", \"180 360 209 389\", \"120 390 259 409\", \"100 390 119 569\", \"260 390 279 569\", \"120 550 259 569\", \"180 570 209 599\", \"0 460 99 499\", \"280 460 399 499\", \"160 450 179 509\", \"200 450 219 509\", \"180 450 199 469\", \"180 490 199 509\"}";
		String expectedResult = "400 12400 12400 14100 14100 16000 87500 ";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}
	
	@Test
	public void test5() {
		String testString = "{}"; 
		String expectedResult = "240000 ";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}
	
	@Test
	public void test6() {
		String testString = "{\"0 0 399 599\"}"; 
		String expectedResult = "";
		
	    myLand = new Land();
	   
		myLand.fillBarrenLand(testString);
		myLand.findLandAreas();
		
		assertEquals(expectedResult, myLand.getLandAreas());
	}
}
