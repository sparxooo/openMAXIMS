// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class ConsultationAssessmentsVoBean extends ims.vo.ValueObjectBean
{
	public ConsultationAssessmentsVoBean()
	{
	}
	public ConsultationAssessmentsVoBean(ims.RefMan.vo.ConsultationAssessmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean();
		this.patientassessment = vo.getPatientAssessment() == null ? null : vo.getPatientAssessment().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.ConsultationAssessmentsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.catsreferral = vo.getCatsReferral() == null ? null : new ims.vo.RefVoBean(vo.getCatsReferral().getBoId(), vo.getCatsReferral().getBoVersion());
		this.authoringinformation = vo.getAuthoringInformation() == null ? null : (ims.core.vo.beans.AuthoringInformationVoBean)vo.getAuthoringInformation().getBean(map);
		this.patientassessment = vo.getPatientAssessment() == null ? null : vo.getPatientAssessment().getBeanCollection();
	}

	public ims.RefMan.vo.ConsultationAssessmentsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.ConsultationAssessmentsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.ConsultationAssessmentsVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.ConsultationAssessmentsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.ConsultationAssessmentsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.RefVoBean getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.vo.RefVoBean value)
	{
		this.catsreferral = value;
	}
	public ims.core.vo.beans.AuthoringInformationVoBean getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.beans.AuthoringInformationVoBean value)
	{
		this.authoringinformation = value;
	}
	public ims.assessment.vo.beans.PatientAssessmentVoBean[] getPatientAssessment()
	{
		return this.patientassessment;
	}
	public void setPatientAssessment(ims.assessment.vo.beans.PatientAssessmentVoBean[] value)
	{
		this.patientassessment = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean catsreferral;
	private ims.core.vo.beans.AuthoringInformationVoBean authoringinformation;
	private ims.assessment.vo.beans.PatientAssessmentVoBean[] patientassessment;
}
