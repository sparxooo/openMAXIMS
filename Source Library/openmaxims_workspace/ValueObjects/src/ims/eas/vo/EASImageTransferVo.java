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

package ims.eas.vo;

/**
 * Linked to EAS.ImageTransfer business object (ID: 1113100003).
 */
public class EASImageTransferVo extends ims.eas.vo.ImageTransferRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EASImageTransferVo()
	{
	}
	public EASImageTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public EASImageTransferVo(ims.eas.vo.beans.EASImageTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagetype = bean.getImageType() == null ? null : ims.oncology.vo.lookups.EASImageType.buildLookup(bean.getImageType());
		this.imagedate = bean.getImageDate() == null ? null : bean.getImageDate().buildPartialDate();
		this.imagetakenat = bean.getImageTakenAt() == null ? null : ims.ccosched.vo.lookups.SeenAt.buildLookup(bean.getImageTakenAt());
		this.locationtaken = bean.getLocationTaken();
		this.anatomicalsite = bean.getAnatomicalSite();
		this.imagerequested = bean.getImageRequested();
		this.removedstat = bean.getRemovedStat();
		this.removalreason = bean.getRemovalReason() == null ? null : ims.eas.vo.lookups.RemovalReason.buildLookup(bean.getRemovalReason());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.eas.vo.beans.EASImageTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.imagetype = bean.getImageType() == null ? null : ims.oncology.vo.lookups.EASImageType.buildLookup(bean.getImageType());
		this.imagedate = bean.getImageDate() == null ? null : bean.getImageDate().buildPartialDate();
		this.imagetakenat = bean.getImageTakenAt() == null ? null : ims.ccosched.vo.lookups.SeenAt.buildLookup(bean.getImageTakenAt());
		this.locationtaken = bean.getLocationTaken();
		this.anatomicalsite = bean.getAnatomicalSite();
		this.imagerequested = bean.getImageRequested();
		this.removedstat = bean.getRemovedStat();
		this.removalreason = bean.getRemovalReason() == null ? null : ims.eas.vo.lookups.RemovalReason.buildLookup(bean.getRemovalReason());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.eas.vo.beans.EASImageTransferVoBean bean = null;
		if(map != null)
			bean = (ims.eas.vo.beans.EASImageTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.eas.vo.beans.EASImageTransferVoBean();
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
		if(fieldName.equals("IMAGETYPE"))
			return getImageType();
		if(fieldName.equals("IMAGEDATE"))
			return getImageDate();
		if(fieldName.equals("IMAGETAKENAT"))
			return getImageTakenAt();
		if(fieldName.equals("LOCATIONTAKEN"))
			return getLocationTaken();
		if(fieldName.equals("ANATOMICALSITE"))
			return getAnatomicalSite();
		if(fieldName.equals("IMAGEREQUESTED"))
			return getImageRequested();
		if(fieldName.equals("REMOVEDSTAT"))
			return getRemovedStat();
		if(fieldName.equals("REMOVALREASON"))
			return getRemovalReason();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getImageTypeIsNotNull()
	{
		return this.imagetype != null;
	}
	public ims.oncology.vo.lookups.EASImageType getImageType()
	{
		return this.imagetype;
	}
	public void setImageType(ims.oncology.vo.lookups.EASImageType value)
	{
		this.isValidated = false;
		this.imagetype = value;
	}
	public boolean getImageDateIsNotNull()
	{
		return this.imagedate != null;
	}
	public ims.framework.utils.PartialDate getImageDate()
	{
		return this.imagedate;
	}
	public void setImageDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.imagedate = value;
	}
	public boolean getImageTakenAtIsNotNull()
	{
		return this.imagetakenat != null;
	}
	public ims.ccosched.vo.lookups.SeenAt getImageTakenAt()
	{
		return this.imagetakenat;
	}
	public void setImageTakenAt(ims.ccosched.vo.lookups.SeenAt value)
	{
		this.isValidated = false;
		this.imagetakenat = value;
	}
	public boolean getLocationTakenIsNotNull()
	{
		return this.locationtaken != null;
	}
	public String getLocationTaken()
	{
		return this.locationtaken;
	}
	public static int getLocationTakenMaxLength()
	{
		return 100;
	}
	public void setLocationTaken(String value)
	{
		this.isValidated = false;
		this.locationtaken = value;
	}
	public boolean getAnatomicalSiteIsNotNull()
	{
		return this.anatomicalsite != null;
	}
	public String getAnatomicalSite()
	{
		return this.anatomicalsite;
	}
	public static int getAnatomicalSiteMaxLength()
	{
		return 100;
	}
	public void setAnatomicalSite(String value)
	{
		this.isValidated = false;
		this.anatomicalsite = value;
	}
	public boolean getImageRequestedIsNotNull()
	{
		return this.imagerequested != null;
	}
	public Boolean getImageRequested()
	{
		return this.imagerequested;
	}
	public void setImageRequested(Boolean value)
	{
		this.isValidated = false;
		this.imagerequested = value;
	}
	public boolean getRemovedStatIsNotNull()
	{
		return this.removedstat != null;
	}
	public Boolean getRemovedStat()
	{
		return this.removedstat;
	}
	public void setRemovedStat(Boolean value)
	{
		this.isValidated = false;
		this.removedstat = value;
	}
	public boolean getRemovalReasonIsNotNull()
	{
		return this.removalreason != null;
	}
	public ims.eas.vo.lookups.RemovalReason getRemovalReason()
	{
		return this.removalreason;
	}
	public void setRemovalReason(ims.eas.vo.lookups.RemovalReason value)
	{
		this.isValidated = false;
		this.removalreason = value;
	}
	/**
	* equals
	*/
		public boolean equals(Object obj)
		{
			if(!(obj instanceof EASImageTransferVo))
				return false;
			EASImageTransferVo compareObj = (EASImageTransferVo)obj;
			if ((imagetype == null ? compareObj.imagetype == null : imagetype.equals(compareObj.imagetype))&&
				(imagedate == null ? compareObj.imagedate == null : imagedate.equals(compareObj.imagedate))&&
				(imagetakenat == null ? compareObj.imagetakenat == null : imagetakenat.equals(compareObj.imagetakenat))&&
				(locationtaken == null ? compareObj.locationtaken == null : locationtaken.equals(compareObj.locationtaken))&&
				(anatomicalsite == null ? compareObj.anatomicalsite == null : anatomicalsite.equals(compareObj.anatomicalsite))&&
				(imagerequested == null ? compareObj.imagerequested == null : imagerequested.equals(compareObj.imagerequested))&&
				(removedstat == null ? compareObj.removedstat == null : removedstat.equals(compareObj.removedstat))&&
				(removalreason == null ? compareObj.removalreason == null : removalreason.equals(compareObj.removalreason)))
					return true;
				return super.equals(obj);
		}
	/**
	* hashCode
	*/
		public int hashCode()
		{
			int hashValue=0;
			if(this.imagetype != null)
				hashValue += this.imagetype.hashCode();
			if(this.imagedate != null)
				hashValue += this.imagedate.hashCode();
			if(this.imagetakenat != null)
				hashValue += this.imagetakenat.hashCode();
			if(this.locationtaken != null)
				hashValue += this.locationtaken.hashCode();
			if(this.anatomicalsite != null)
				hashValue += this.anatomicalsite.hashCode();
			if (this.imagerequested != null)
				hashValue += this.imagerequested.hashCode();
			if (this.removedstat!=null)
				hashValue += this.removedstat.hashCode();
			if (this.removalreason!=null)
				hashValue += this.removalreason.hashCode();
			return hashValue;
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
		if(this.imagetype == null)
			listOfErrors.add("ImageType is mandatory");
		if(this.locationtaken != null)
			if(this.locationtaken.length() > 100)
				listOfErrors.add("The length of the field [locationtaken] in the value object [ims.eas.vo.EASImageTransferVo] is too big. It should be less or equal to 100");
		if(this.anatomicalsite != null)
			if(this.anatomicalsite.length() > 100)
				listOfErrors.add("The length of the field [anatomicalsite] in the value object [ims.eas.vo.EASImageTransferVo] is too big. It should be less or equal to 100");
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
	
		EASImageTransferVo clone = new EASImageTransferVo(this.id, this.version);
		
		if(this.imagetype == null)
			clone.imagetype = null;
		else
			clone.imagetype = (ims.oncology.vo.lookups.EASImageType)this.imagetype.clone();
		if(this.imagedate == null)
			clone.imagedate = null;
		else
			clone.imagedate = (ims.framework.utils.PartialDate)this.imagedate.clone();
		if(this.imagetakenat == null)
			clone.imagetakenat = null;
		else
			clone.imagetakenat = (ims.ccosched.vo.lookups.SeenAt)this.imagetakenat.clone();
		clone.locationtaken = this.locationtaken;
		clone.anatomicalsite = this.anatomicalsite;
		clone.imagerequested = this.imagerequested;
		clone.removedstat = this.removedstat;
		if(this.removalreason == null)
			clone.removalreason = null;
		else
			clone.removalreason = (ims.eas.vo.lookups.RemovalReason)this.removalreason.clone();
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
		if (!(EASImageTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EASImageTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EASImageTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EASImageTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.imagetype != null)
			count++;
		if(this.imagedate != null)
			count++;
		if(this.imagetakenat != null)
			count++;
		if(this.locationtaken != null)
			count++;
		if(this.anatomicalsite != null)
			count++;
		if(this.imagerequested != null)
			count++;
		if(this.removedstat != null)
			count++;
		if(this.removalreason != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.oncology.vo.lookups.EASImageType imagetype;
	protected ims.framework.utils.PartialDate imagedate;
	protected ims.ccosched.vo.lookups.SeenAt imagetakenat;
	protected String locationtaken;
	protected String anatomicalsite;
	protected Boolean imagerequested;
	protected Boolean removedstat;
	protected ims.eas.vo.lookups.RemovalReason removalreason;
	private boolean isValidated = false;
	private boolean isBusy = false;
}