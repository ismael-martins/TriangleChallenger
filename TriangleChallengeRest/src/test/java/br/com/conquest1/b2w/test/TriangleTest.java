package br.com.conquest1.b2w.test;

import br.com.conquest1.b2w.controller.TriangleController;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	TriangleController triangleController = new TriangleController();
	
	@Test
	public void testTriangleTwoLevels() {
		int maxTotal = triangleController.calculateTriangle("[[5],[7,9]]");
		Assert.assertEquals(14, maxTotal);
	}
	
	@Test
	public void testTriangleThreeLevels() {
		int maxTotal = triangleController.calculateTriangle("[[3],[2,6],[5,9,7]]");
		Assert.assertEquals(18, maxTotal);
	}
	
	@Test
	public void testTriangleFourLevels() {
		int maxTotal = triangleController.calculateTriangle("[[7],[8,3],[7,5,9],[8,1,5,9]]");
		Assert.assertEquals(30, maxTotal);
	}
	
	@Test
	public void testTriangleExample() {
		int maxTotal = triangleController.calculateTriangle("[[6],[3,5],[9,7,1],[4,6,8,4]]");
		Assert.assertEquals(26, maxTotal);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTriangleInvalidValue() throws IllegalArgumentException {
		int maxTotal = triangleController.calculateTriangle("[[4],[2,6],[3,5,9],[0,6,2,4");
	}
}
