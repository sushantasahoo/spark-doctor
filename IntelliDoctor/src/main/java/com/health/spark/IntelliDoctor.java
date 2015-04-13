package com.health.spark;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

/**
 * 
 * @author Sahoo
 * @since 03/28/2015
 *
 */
public class IntelliDoctor {

	public static Map<String, String> patientSymptom = new HashMap<>();
	private static String path = ".\\inputData.txt";

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName(
				"IntelliDoctor");

		JavaSparkContext jsc = new JavaSparkContext(sparkConf);
		SQLContext sqlContext = new SQLContext(jsc);
		DataFrame patientDataFrame = sqlContext.jsonFile(path);
		// Filtering patients with Alzheimer's disease
		patientDataFrame
				.filter(patientDataFrame.col("symptoms").equalTo("Mood swings"))
				.select(patientDataFrame.col("name"))
				.intersect(
						patientDataFrame.filter(
								patientDataFrame.col("symptoms").equalTo(
										"Memory Loss")).select(
								patientDataFrame.col("name")))

				.intersect(
						patientDataFrame.filter(
								patientDataFrame.col("symptoms").equalTo(
										"Poor Judgement")).select(
								patientDataFrame.col("name"))).show();
		// patientDataFrame.filter(patientDataFrame.col("symptoms").equalTo("Memory Loss"))
		// .filter(patientDataFrame.col("symptoms").equalTo(
		// "Poor Judgement")).show();

		// patientDataFrame.show();
	}
}
