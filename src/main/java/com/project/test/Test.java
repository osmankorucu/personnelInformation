package com.project.test;

import java.util.Calendar;
import java.util.Date;

import com.project.model.Children;
import com.project.model.EducationStatus;
import com.project.model.Personnel;
import com.project.model.util.EducationType;
import com.project.repository.Repository;
import com.project.repository.impl.RepositoryImpl;

public class Test {
	public static void main(String[] args) {
		Repository repository = new RepositoryImpl();

		Personnel personnel = new Personnel("Osman", "KORUCU", "Erkek", createDate(11, 7, 1997), "osman25korucu@gmail.com",
				"+905537045625", "Şükrüpaşa Mah. Şıhköyü Cad. Tugay Sitesi A Bl. Kat: 3 No: 10 Yakutiye/Erzurum", "Bekar",
				null);
		personnel.addChildren(new Children("Ali", "KORUCU", "Erkek", createDate(11, 11, 2011)));
		personnel.addEducationStatus(new EducationStatus("Mehmet Akif Ersoy Anadolu Lisesi", "Erzurum",
				createDate(15, 9, 2011), createDate(15, 6, 2015), EducationType.LISE));
		repository.createPersonnel(personnel);
	}

	public static Date createDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}
}
