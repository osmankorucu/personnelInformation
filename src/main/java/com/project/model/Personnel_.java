package com.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-01-10T17:49:07.717+0300")
@StaticMetamodel(Personnel.class)
public class Personnel_ {
	public static volatile SingularAttribute<Personnel, Integer> prsId;
	public static volatile SingularAttribute<Personnel, String> prsIDNumber;
	public static volatile SingularAttribute<Personnel, String> prsName;
	public static volatile SingularAttribute<Personnel, String> prsSurname;
	public static volatile SingularAttribute<Personnel, String> prsGender;
	public static volatile SingularAttribute<Personnel, Date> prsDateOfBirth;
	public static volatile SingularAttribute<Personnel, String> prsEMail;
	public static volatile SingularAttribute<Personnel, String> prsPhoneNumber;
	public static volatile SingularAttribute<Personnel, String> prsAddress;
	public static volatile ListAttribute<Personnel, EducationStatus> prsEducationStatus;
	public static volatile ListAttribute<Personnel, Children> prsChildren;
	public static volatile SingularAttribute<Personnel, String> prsIsMarried;
	public static volatile SingularAttribute<Personnel, String> prsPhoto;
}
