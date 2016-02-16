//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.admin.pas.DischargedEpisode business object (ID: 1014100006).
 */
public class ADTDischargeEpisodeVo extends ims.core.admin.pas.vo.DischargedEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ADTDischargeEpisodeVo()
	{
	}
	public ADTDischargeEpisodeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ADTDischargeEpisodeVo(ims.core.vo.beans.ADTDischargeEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		if(bean.getWardStays() != null)
		{
			this.wardstays = new ims.core.admin.pas.vo.WardStayRefVoCollection();
			for(int wardstays_i = 0; wardstays_i < bean.getWardStays().length; wardstays_i++)
			{
				this.wardstays.add(new ims.core.admin.pas.vo.WardStayRefVo(new Integer(bean.getWardStays()[wardstays_i].getId()), bean.getWardStays()[wardstays_i].getVersion()));
			}
		}
		if(bean.getConsultantStays() != null)
		{
			this.consultantstays = new ims.core.admin.pas.vo.ConsultantStayRefVoCollection();
			for(int consultantstays_i = 0; consultantstays_i < bean.getConsultantStays().length; consultantstays_i++)
			{
				this.consultantstays.add(new ims.core.admin.pas.vo.ConsultantStayRefVo(new Integer(bean.getConsultantStays()[consultantstays_i].getId()), bean.getConsultantStays()[consultantstays_i].getVersion()));
			}
		}
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.isactive = bean.getIsActive();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.methodofdischarge = bean.getMethodOfDischarge() == null ? null : ims.core.vo.lookups.MethodOfDischarge.buildLookup(bean.getMethodOfDischarge());
		this.wastreatmentdeferred = bean.getWasTreatmentDeferred();
		this.treatmentdeferredreason = bean.getTreatmentDeferredReason() == null ? null : ims.core.vo.lookups.TreatmentDeferredReason.buildLookup(bean.getTreatmentDeferredReason());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.readmissiontype = bean.getReadmissionType() == null ? null : ims.core.vo.lookups.ReadmissionType.buildLookup(bean.getReadmissionType());
		this.dischargereadydate = bean.getDischargeReadyDate() == null ? null : bean.getDischargeReadyDate().buildDate();
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.extendeddetails = bean.getExtendedDetails() == null ? null : bean.getExtendedDetails().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ADTDischargeEpisodeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		if(bean.getWardStays() != null)
		{
			this.wardstays = new ims.core.admin.pas.vo.WardStayRefVoCollection();
			for(int wardstays_i = 0; wardstays_i < bean.getWardStays().length; wardstays_i++)
			{
				this.wardstays.add(new ims.core.admin.pas.vo.WardStayRefVo(new Integer(bean.getWardStays()[wardstays_i].getId()), bean.getWardStays()[wardstays_i].getVersion()));
			}
		}
		if(bean.getConsultantStays() != null)
		{
			this.consultantstays = new ims.core.admin.pas.vo.ConsultantStayRefVoCollection();
			for(int consultantstays_i = 0; consultantstays_i < bean.getConsultantStays().length; consultantstays_i++)
			{
				this.consultantstays.add(new ims.core.admin.pas.vo.ConsultantStayRefVo(new Integer(bean.getConsultantStays()[consultantstays_i].getId()), bean.getConsultantStays()[consultantstays_i].getVersion()));
			}
		}
		this.dischargedatetime = bean.getDischargeDateTime() == null ? null : bean.getDischargeDateTime().buildDateTime();
		this.isactive = bean.getIsActive();
		this.dischargedestination = bean.getDischargeDestination() == null ? null : ims.coe.vo.lookups.DischargeDestination.buildLookup(bean.getDischargeDestination());
		this.methodofdischarge = bean.getMethodOfDischarge() == null ? null : ims.core.vo.lookups.MethodOfDischarge.buildLookup(bean.getMethodOfDischarge());
		this.wastreatmentdeferred = bean.getWasTreatmentDeferred();
		this.treatmentdeferredreason = bean.getTreatmentDeferredReason() == null ? null : ims.core.vo.lookups.TreatmentDeferredReason.buildLookup(bean.getTreatmentDeferredReason());
		this.admissiontype = bean.getAdmissionType() == null ? null : ims.core.vo.lookups.AdmissionType.buildLookup(bean.getAdmissionType());
		this.readmissiontype = bean.getReadmissionType() == null ? null : ims.core.vo.lookups.ReadmissionType.buildLookup(bean.getReadmissionType());
		this.dischargereadydate = bean.getDischargeReadyDate() == null ? null : bean.getDischargeReadyDate().buildDate();
		this.admissiondetail = bean.getAdmissionDetail() == null ? null : new ims.core.admin.pas.vo.AdmissionDetailRefVo(new Integer(bean.getAdmissionDetail().getId()), bean.getAdmissionDetail().getVersion());
		this.extendeddetails = bean.getExtendedDetails() == null ? null : bean.getExtendedDetails().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ADTDischargeEpisodeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ADTDischargeEpisodeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ADTDischargeEpisodeVoBean();
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
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("WARDSTAYS"))
			return getWardStays();
		if(fieldName.equals("CONSULTANTSTAYS"))
			return getConsultantStays();
		if(fieldName.equals("DISCHARGEDATETIME"))
			return getDischargeDateTime();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("DISCHARGEDESTINATION"))
			return getDischargeDestination();
		if(fieldName.equals("METHODOFDISCHARGE"))
			return getMethodOfDischarge();
		if(fieldName.equals("WASTREATMENTDEFERRED"))
			return getWasTreatmentDeferred();
		if(fieldName.equals("TREATMENTDEFERREDREASON"))
			return getTreatmentDeferredReason();
		if(fieldName.equals("ADMISSIONTYPE"))
			return getAdmissionType();
		if(fieldName.equals("READMISSIONTYPE"))
			return getReadmissionType();
		if(fieldName.equals("DISCHARGEREADYDATE"))
			return getDischargeReadyDate();
		if(fieldName.equals("ADMISSIONDETAIL"))
			return getAdmissionDetail();
		if(fieldName.equals("EXTENDEDDETAILS"))
			return getExtendedDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventADTVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventADTVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getWardStaysIsNotNull()
	{
		return this.wardstays != null;
	}
	public ims.core.admin.pas.vo.WardStayRefVoCollection getWardStays()
	{
		return this.wardstays;
	}
	public void setWardStays(ims.core.admin.pas.vo.WardStayRefVoCollection value)
	{
		this.isValidated = false;
		this.wardstays = value;
	}
	public boolean getConsultantStaysIsNotNull()
	{
		return this.consultantstays != null;
	}
	public ims.core.admin.pas.vo.ConsultantStayRefVoCollection getConsultantStays()
	{
		return this.consultantstays;
	}
	public void setConsultantStays(ims.core.admin.pas.vo.ConsultantStayRefVoCollection value)
	{
		this.isValidated = false;
		this.consultantstays = value;
	}
	public boolean getDischargeDateTimeIsNotNull()
	{
		return this.dischargedatetime != null;
	}
	public ims.framework.utils.DateTime getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dischargedatetime = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getDischargeDestinationIsNotNull()
	{
		return this.dischargedestination != null;
	}
	public ims.coe.vo.lookups.DischargeDestination getDischargeDestination()
	{
		return this.dischargedestination;
	}
	public void setDischargeDestination(ims.coe.vo.lookups.DischargeDestination value)
	{
		this.isValidated = false;
		this.dischargedestination = value;
	}
	public boolean getMethodOfDischargeIsNotNull()
	{
		return this.methodofdischarge != null;
	}
	public ims.core.vo.lookups.MethodOfDischarge getMethodOfDischarge()
	{
		return this.methodofdischarge;
	}
	public void setMethodOfDischarge(ims.core.vo.lookups.MethodOfDischarge value)
	{
		this.isValidated = false;
		this.methodofdischarge = value;
	}
	public boolean getWasTreatmentDeferredIsNotNull()
	{
		return this.wastreatmentdeferred != null;
	}
	public Boolean getWasTreatmentDeferred()
	{
		return this.wastreatmentdeferred;
	}
	public void setWasTreatmentDeferred(Boolean value)
	{
		this.isValidated = false;
		this.wastreatmentdeferred = value;
	}
	public boolean getTreatmentDeferredReasonIsNotNull()
	{
		return this.treatmentdeferredreason != null;
	}
	public ims.core.vo.lookups.TreatmentDeferredReason getTreatmentDeferredReason()
	{
		return this.treatmentdeferredreason;
	}
	public void setTreatmentDeferredReason(ims.core.vo.lookups.TreatmentDeferredReason value)
	{
		this.isValidated = false;
		this.treatmentdeferredreason = value;
	}
	public boolean getAdmissionTypeIsNotNull()
	{
		return this.admissiontype != null;
	}
	public ims.core.vo.lookups.AdmissionType getAdmissionType()
	{
		return this.admissiontype;
	}
	public void setAdmissionType(ims.core.vo.lookups.AdmissionType value)
	{
		this.isValidated = false;
		this.admissiontype = value;
	}
	public boolean getReadmissionTypeIsNotNull()
	{
		return this.readmissiontype != null;
	}
	public ims.core.vo.lookups.ReadmissionType getReadmissionType()
	{
		return this.readmissiontype;
	}
	public void setReadmissionType(ims.core.vo.lookups.ReadmissionType value)
	{
		this.isValidated = false;
		this.readmissiontype = value;
	}
	public boolean getDischargeReadyDateIsNotNull()
	{
		return this.dischargereadydate != null;
	}
	public ims.framework.utils.Date getDischargeReadyDate()
	{
		return this.dischargereadydate;
	}
	public void setDischargeReadyDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.dischargereadydate = value;
	}
	public boolean getAdmissionDetailIsNotNull()
	{
		return this.admissiondetail != null;
	}
	public ims.core.admin.pas.vo.AdmissionDetailRefVo getAdmissionDetail()
	{
		return this.admissiondetail;
	}
	public void setAdmissionDetail(ims.core.admin.pas.vo.AdmissionDetailRefVo value)
	{
		this.isValidated = false;
		this.admissiondetail = value;
	}
	public boolean getExtendedDetailsIsNotNull()
	{
		return this.extendeddetails != null;
	}
	public ims.core.vo.ExtendedDischargeDetailVo getExtendedDetails()
	{
		return this.extendeddetails;
	}
	public void setExtendedDetails(ims.core.vo.ExtendedDischargeDetailVo value)
	{
		this.isValidated = false;
		this.extendeddetails = value;
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
	
		ADTDischargeEpisodeVo clone = new ADTDischargeEpisodeVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventADTVo)this.pasevent.clone();
		clone.wardstays = this.wardstays;
		clone.consultantstays = this.consultantstays;
		if(this.dischargedatetime == null)
			clone.dischargedatetime = null;
		else
			clone.dischargedatetime = (ims.framework.utils.DateTime)this.dischargedatetime.clone();
		clone.isactive = this.isactive;
		if(this.dischargedestination == null)
			clone.dischargedestination = null;
		else
			clone.dischargedestination = (ims.coe.vo.lookups.DischargeDestination)this.dischargedestination.clone();
		if(this.methodofdischarge == null)
			clone.methodofdischarge = null;
		else
			clone.methodofdischarge = (ims.core.vo.lookups.MethodOfDischarge)this.methodofdischarge.clone();
		clone.wastreatmentdeferred = this.wastreatmentdeferred;
		if(this.treatmentdeferredreason == null)
			clone.treatmentdeferredreason = null;
		else
			clone.treatmentdeferredreason = (ims.core.vo.lookups.TreatmentDeferredReason)this.treatmentdeferredreason.clone();
		if(this.admissiontype == null)
			clone.admissiontype = null;
		else
			clone.admissiontype = (ims.core.vo.lookups.AdmissionType)this.admissiontype.clone();
		if(this.readmissiontype == null)
			clone.readmissiontype = null;
		else
			clone.readmissiontype = (ims.core.vo.lookups.ReadmissionType)this.readmissiontype.clone();
		if(this.dischargereadydate == null)
			clone.dischargereadydate = null;
		else
			clone.dischargereadydate = (ims.framework.utils.Date)this.dischargereadydate.clone();
		clone.admissiondetail = this.admissiondetail;
		if(this.extendeddetails == null)
			clone.extendeddetails = null;
		else
			clone.extendeddetails = (ims.core.vo.ExtendedDischargeDetailVo)this.extendeddetails.clone();
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
		if (!(ADTDischargeEpisodeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ADTDischargeEpisodeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ADTDischargeEpisodeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ADTDischargeEpisodeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pasevent != null)
			count++;
		if(this.wardstays != null)
			count++;
		if(this.consultantstays != null)
			count++;
		if(this.dischargedatetime != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.dischargedestination != null)
			count++;
		if(this.methodofdischarge != null)
			count++;
		if(this.wastreatmentdeferred != null)
			count++;
		if(this.treatmentdeferredreason != null)
			count++;
		if(this.admissiontype != null)
			count++;
		if(this.readmissiontype != null)
			count++;
		if(this.dischargereadydate != null)
			count++;
		if(this.admissiondetail != null)
			count++;
		if(this.extendeddetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 14;
	}
	protected ims.core.vo.PasEventADTVo pasevent;
	protected ims.core.admin.pas.vo.WardStayRefVoCollection wardstays;
	protected ims.core.admin.pas.vo.ConsultantStayRefVoCollection consultantstays;
	protected ims.framework.utils.DateTime dischargedatetime;
	protected Boolean isactive;
	protected ims.coe.vo.lookups.DischargeDestination dischargedestination;
	protected ims.core.vo.lookups.MethodOfDischarge methodofdischarge;
	protected Boolean wastreatmentdeferred;
	protected ims.core.vo.lookups.TreatmentDeferredReason treatmentdeferredreason;
	protected ims.core.vo.lookups.AdmissionType admissiontype;
	protected ims.core.vo.lookups.ReadmissionType readmissiontype;
	protected ims.framework.utils.Date dischargereadydate;
	protected ims.core.admin.pas.vo.AdmissionDetailRefVo admissiondetail;
	protected ims.core.vo.ExtendedDischargeDetailVo extendeddetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}