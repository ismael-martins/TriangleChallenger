package br.com.conquest1.b2w.controller;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Stream;

public class TriangleController {

	private static final String REGEX_PARAMS = "(\\[)(.+)(\\])";
	private static final String REGEX = "((\\[|\\{)(((\\d+),?)+)(\\]|\\}))";

	public int calculateTriangle(String input) throws IllegalArgumentException {

		if (!validateRegex(input, REGEX_PARAMS)) {
			throw new IllegalArgumentException("400 Bad Request");
		}
		
		Integer[][] triangleValues = getTriangleValues(input);
		int retorno = calculateMaxTriangleValue(triangleValues);

		return retorno;
	}

	private int calculateMaxTriangleValue(Integer[][] triangleValues) {

		int total = 0;
		int position = 0;
		
		for (int i=0; i < triangleValues.length; i++) {
			if (i==0) {
				total = triangleValues[i][0];
			} else {
				position = obterPosicaoMaior(triangleValues[i], position);
				total += triangleValues[i][position];
			}
			
		}

		return total;
	}
	
	private static int obterPosicaoMaior(Integer[] triangleValues, int position) {
		int valorAtual = 0;
		int positionMax = 0;
		for (int i=position; i <= position+1; i++) {
			if (triangleValues[i] > valorAtual) {
				valorAtual = triangleValues[i];
				positionMax = i;
			}
		}
		return positionMax;
	}

	private boolean validateRegex(String input, String regex) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	protected Integer[][] getTriangleValues (String values) {
        List<Integer[]> lineList = new ArrayList<Integer[]>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(values);
        while (matcher.find()) {
            String group = matcher.group(3);
            Integer[] row = Arrays.stream( Stream.of(group.split(",")).mapToInt(Integer::parseInt).toArray() ).boxed().toArray(Integer[]::new);
            lineList.add(row);
        }
        Integer[][] valuesTriangles = new Integer[lineList.size()][];
        for (int i = 0; i < valuesTriangles.length; i++) {
        	valuesTriangles[i] = lineList.get(i);
        }
        return valuesTriangles;
    }
}
