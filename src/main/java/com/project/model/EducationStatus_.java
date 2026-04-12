package com.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-07T23:05:16.643+0300")
@StaticMetamodel(EducationStatus.class)
public class EducationStatus_ {
	public static volatile SingularAttribute<EducationStatus, Integer> esId;
	public static volatile SingularAttribute<EducationStatus, String> esName;
	public static volatile SingularAttribute<EducationStatus, String> esCity;
	public static volatile SingularAttribute<EducationStatus, Date> esStartDate;
	public static volatile SingularAttribute<EducationStatus, Date> esGraduatedDate;
	public static volatile SingularAttribute<EducationStatus, String> esType;
}
