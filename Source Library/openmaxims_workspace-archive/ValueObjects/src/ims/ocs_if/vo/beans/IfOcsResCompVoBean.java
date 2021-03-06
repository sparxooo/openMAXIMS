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

package ims.ocs_if.vo.beans;

public class IfOcsResCompVoBean extends ims.vo.ValueObjectBean
{
	public IfOcsResCompVoBean()
	{
	}
	public IfOcsResCompVoBean(ims.ocs_if.vo.IfOcsResCompVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyte = vo.getAnalyte() == null ? null : (ims.ocs_if.vo.beans.IfAnalyteVoBean)vo.getAnalyte().getBean();
		this.resvaltype = vo.getResValType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResValType().getBean();
		this.formattedtext = vo.getFormattedText();
		this.resultval = vo.getResultVal();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
		this.refrange = vo.getRefRange();
		this.normalcystatus = vo.getNormalcyStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNormalcyStatus().getBean();
		this.isabnormal = vo.getIsAbnormal();
		this.obsdatetime = vo.getObsDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getObsDateTime().getBean();
		this.obstimesupplied = vo.getObsTimeSupplied();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.resultcomponentcomments = vo.getResultComponentComments() == null ? null : vo.getResultComponentComments().getBeanCollection();
		this.edsubtype = vo.getEDSubType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEDSubType().getBean();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocs_if.vo.IfOcsResCompVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.analyte = vo.getAnalyte() == null ? null : (ims.ocs_if.vo.beans.IfAnalyteVoBean)vo.getAnalyte().getBean(map);
		this.resvaltype = vo.getResValType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResValType().getBean();
		this.formattedtext = vo.getFormattedText();
		this.resultval = vo.getResultVal();
		this.unitofmeasure = vo.getUnitOfMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getUnitOfMeasure().getBean();
		this.refrange = vo.getRefRange();
		this.normalcystatus = vo.getNormalcyStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getNormalcyStatus().getBean();
		this.isabnormal = vo.getIsAbnormal();
		this.obsdatetime = vo.getObsDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getObsDateTime().getBean();
		this.obstimesupplied = vo.getObsTimeSupplied();
		this.resultstatus = vo.getResultStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultStatus().getBean();
		this.resultcomponentcomments = vo.getResultComponentComments() == null ? null : vo.getResultComponentComments().getBeanCollection();
		this.edsubtype = vo.getEDSubType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEDSubType().getBean();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.resultspecimentype = vo.getResultSpecimenType() == null ? null : (ims.vo.LookupInstanceBean)vo.getResultSpecimenType().getBean();
	}

	public ims.ocs_if.vo.IfOcsResCompVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocs_if.vo.IfOcsResCompVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocs_if.vo.IfOcsResCompVo vo = null;
		if(map != null)
			vo = (ims.ocs_if.vo.IfOcsResCompVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocs_if.vo.IfOcsResCompVo();
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
	public ims.ocs_if.vo.beans.IfAnalyteVoBean getAnalyte()
	{
		return this.analyte;
	}
	public void setAnalyte(ims.ocs_if.vo.beans.IfAnalyteVoBean value)
	{
		this.analyte = value;
	}
	public ims.vo.LookupInstanceBean getResValType()
	{
		return this.resvaltype;
	}
	public void setResValType(ims.vo.LookupInstanceBean value)
	{
		this.resvaltype = value;
	}
	public String getFormattedText()
	{
		return this.formattedtext;
	}
	public void setFormattedText(String value)
	{
		this.formattedtext = value;
	}
	public String getResultVal()
	{
		return this.resultval;
	}
	public void setResultVal(String value)
	{
		this.resultval = value;
	}
	public ims.vo.LookupInstanceBean getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.vo.LookupInstanceBean value)
	{
		this.unitofmeasure = value;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public void setRefRange(String value)
	{
		this.refrange = value;
	}
	public ims.vo.LookupInstanceBean getNormalcyStatus()
	{
		return this.normalcystatus;
	}
	public void setNormalcyStatus(ims.vo.LookupInstanceBean value)
	{
		this.normalcystatus = value;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isabnormal = value;
	}
	public ims.framework.utils.beans.DateTimeBean getObsDateTime()
	{
		return this.obsdatetime;
	}
	public void setObsDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.obsdatetime = value;
	}
	public Boolean getObsTimeSupplied()
	{
		return this.obstimesupplied;
	}
	public void setObsTimeSupplied(Boolean value)
	{
		this.obstimesupplied = value;
	}
	public ims.vo.LookupInstanceBean getResultStatus()
	{
		return this.resultstatus;
	}
	public void setResultStatus(ims.vo.LookupInstanceBean value)
	{
		this.resultstatus = value;
	}
	public ims.ocs_if.vo.beans.IfOcsResCommentVoBean[] getResultComponentComments()
	{
		return this.resultcomponentcomments;
	}
	public void setResultComponentComments(ims.ocs_if.vo.beans.IfOcsResCommentVoBean[] value)
	{
		this.resultcomponentcomments = value;
	}
	public ims.vo.LookupInstanceBean getEDSubType()
	{
		return this.edsubtype;
	}
	public void setEDSubType(ims.vo.LookupInstanceBean value)
	{
		this.edsubtype = value;
	}
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.vo.LookupInstanceBean getResultSpecimenType()
	{
		return this.resultspecimentype;
	}
	public void setResultSpecimenType(ims.vo.LookupInstanceBean value)
	{
		this.resultspecimentype = value;
	}

	private Integer id;
	private int version;
	private ims.ocs_if.vo.beans.IfAnalyteVoBean analyte;
	private ims.vo.LookupInstanceBean resvaltype;
	private String formattedtext;
	private String resultval;
	private ims.vo.LookupInstanceBean unitofmeasure;
	private String refrange;
	private ims.vo.LookupInstanceBean normalcystatus;
	private Boolean isabnormal;
	private ims.framework.utils.beans.DateTimeBean obsdatetime;
	private Boolean obstimesupplied;
	private ims.vo.LookupInstanceBean resultstatus;
	private ims.ocs_if.vo.beans.IfOcsResCommentVoBean[] resultcomponentcomments;
	private ims.vo.LookupInstanceBean edsubtype;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.vo.LookupInstanceBean resultspecimentype;
}
