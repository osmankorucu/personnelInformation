package com.project.model;

import com.project.model.util.EducationType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-12-25T22:27:52.134+0300")
@StaticMetamodel(EducationStatus.class)
public class EducationStatus_ {
	public static volatile SingularAttribute<EducationStatus, Integer> esId;
	public static volatile SingularAttribute<EducationStatus, String> esName;
	public static volatile SingularAttribute<EducationStatus, String> esCity;
	public static volatile SingularAttribute<EducationStatus, Date> esStartDate;
	public static volatile SingularAttribute<EducationStatus, Date> esGraduatedDate;
	public static volatile SingularAttribute<EducationStatus, EducationType> esType;
}
