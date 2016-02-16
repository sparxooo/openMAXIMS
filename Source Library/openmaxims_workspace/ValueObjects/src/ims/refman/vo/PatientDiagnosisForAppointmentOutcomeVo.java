//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to core.clinical.PatientDiagnosis business object (ID: 1003100016).
 */
public class PatientDiagnosisForAppointmentOutcomeVo extends ims.core.clinical.vo.PatientDiagnosisRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IClinicalCodingValue
{
	private static final long serialVersionUID = 1L;

	public PatientDiagnosisForAppointmentOutcomeVo()
	{
	}
	public PatientDiagnosisForAppointmentOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDiagnosisForAppointmentOutcomeVo(ims.RefMan.vo.beans.PatientDiagnosisForAppointmentOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo();
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.diagnosedonadmission = bean.getDiagnosedOnAdmission();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientDiagnosisForAppointmentOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo(map);
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : new ims.core.admin.vo.EpisodeOfCareRefVo(new Integer(bean.getEpisodeOfCare().getId()), bean.getEpisodeOfCare().getVersion());
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.diagnosedonadmission = bean.getDiagnosedOnAdmission();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientDiagnosisForAppointmentOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientDiagnosisForAppointmentOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientDiagnosisForAppointmentOutcomeVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("DIAGNOSISDESCRIPTION"))
			return getDiagnosisDescription();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		if(fieldName.equals("DIAGNOSEDDATE"))
			return getDiagnosedDate();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("DIAGNOSEDONADMISSION"))
			return getDiagnosedOnAdmission();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.vo.DiagLiteVo getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.DiagLiteVo value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getDiagnosisDescriptionIsNotNull()
	{
		return this.diagnosisdescription != null;
	}
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public static int getDiagnosisDescriptionMaxLength()
	{
		return 255;
	}
	public void setDiagnosisDescription(String value)
	{
		this.isValidated = false;
		this.diagnosisdescription = value;
	}
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.admin.vo.EpisodeOfCareRefVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.admin.vo.EpisodeOfCareRefVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
	}
	public boolean getDiagnosedDateIsNotNull()
	{
		return this.diagnoseddate != null;
	}
	public ims.framework.utils.PartialDate getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.diagnoseddate = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.RefMan.vo.PatientDiagnosisStatusForAppointmentOutcomeVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.PatientDiagnosisStatusForAppointmentOutcomeVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getDiagnosedOnAdmissionIsNotNull()
	{
		return this.diagnosedonadmission != null;
	}
	public Boolean getDiagnosedOnAdmission()
	{
		return this.diagnosedonadmission;
	}
	public void setDiagnosedOnAdmission(Boolean value)
	{
		this.isValidated = false;
		this.diagnosedonadmission = value;
	}
	/**
	* IclinicalCodingValue methods
	*/
	public ims.vo.ValueObject getIClinicalCodingValue() 
	{
		return this.getDiagnosis();
	}
	public String getIClinicalCodingValueDescription() 
	{
		return this.getDiagnosisDescription();
	}
	public void setIClinicalCodingValue(ims.vo.ValueObject vo) 
	{
		if (vo instanceof ims.core.vo.DiagLiteVo)
		{
			this.setDiagnosis((ims.core.vo.DiagLiteVo) vo);
		}
	}
	public void setIClinicalCodingValueDescription(String value) 
	{
		this.setDiagnosisDescription(value);
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.authoringinfo != null)
		{
			if(!this.authoringinfo.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.diagnosisdescription == null || this.diagnosisdescription.length() == 0)
			listOfErrors.add("Diagnosis Description is mandatory");
		else if(this.diagnosisdescription.length() > 255)
			listOfErrors.add("The length of the field [diagnosisdescription] in the value object [ims.RefMan.vo.PatientDiagnosisForAppointmentOutcomeVo] is too big. It should be less or equal to 255");
		if(this.sourceofinformation == null)
			listOfErrors.add("SourceofInformation is mandatory");
		if(this.episodeofcare == null)
			listOfErrors.add("EpisodeOfCare is mandatory");
		if(this.authoringinfo != null)
		{
			String[] listOfOtherErrors = this.authoringinfo.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientDiagnosisForAppointmentOutcomeVo clone = new PatientDiagnosisForAppointmentOutcomeVo(this.id, this.version);
		
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.DiagLiteVo)this.diagnosis.clone();
		clone.diagnosisdescription = this.diagnosisdescription;
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		clone.episodeofcare = this.episodeofcare;
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		if(this.diagnoseddate == null)
			clone.diagnoseddate = null;
		else
			clone.diagnoseddate = (ims.framework.utils.PartialDate)this.diagnoseddate.clone();
		clone.carecontext = this.carecontext;
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.RefMan.vo.PatientDiagnosisStatusForAppointmentOutcomeVo)this.currentstatus.clone();
		clone.diagnosedonadmission = this.diagnosedonadmission;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientDiagnosisForAppointmentOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDiagnosisForAppointmentOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDiagnosisForAppointmentOutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDiagnosisForAppointmentOutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.diagnosis != null)
			count++;
		if(this.diagnosisdescription != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.authoringinfo != null)
			count++;
		if(this.diagnoseddate != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.diagnosedonadmission != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.DiagLiteVo diagnosis;
	protected String diagnosisdescription;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	protected ims.core.admin.vo.EpisodeOfCareRefVo episodeofcare;
	protected ims.core.vo.AuthoringInformationVo authoringinfo;
	protected ims.framework.utils.PartialDate diagnoseddate;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.RefMan.vo.PatientDiagnosisStatusForAppointmentOutcomeVo currentstatus;
	protected Boolean diagnosedonadmission;
	private boolean isValidated = false;
	private boolean isBusy = false;
}