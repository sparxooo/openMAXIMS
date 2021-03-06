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

package ims.spinalinjuries.vo.beans;

public class RespExamAuscBean extends ims.vo.ValueObjectBean
{
	public RespExamAuscBean()
	{
	}
	public RespExamAuscBean(ims.spinalinjuries.vo.RespExamAusc vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.auscname = vo.getAuscName();
		this.auscdescription = vo.getAuscDescription();
		this.auscnote = vo.getAuscNote();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.spinalinjuries.vo.RespExamAusc vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.auscname = vo.getAuscName();
		this.auscdescription = vo.getAuscDescription();
		this.auscnote = vo.getAuscNote();
	}

	public ims.spinalinjuries.vo.RespExamAusc buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.spinalinjuries.vo.RespExamAusc buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.spinalinjuries.vo.RespExamAusc vo = null;
		if(map != null)
			vo = (ims.spinalinjuries.vo.RespExamAusc)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.spinalinjuries.vo.RespExamAusc();
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
	public String getAuscName()
	{
		return this.auscname;
	}
	public void setAuscName(String value)
	{
		this.auscname = value;
	}
	public String getAuscDescription()
	{
		return this.auscdescription;
	}
	public void setAuscDescription(String value)
	{
		this.auscdescription = value;
	}
	public String getAuscNote()
	{
		return this.auscnote;
	}
	public void setAuscNote(String value)
	{
		this.auscnote = value;
	}

	private Integer id;
	private int version;
	private String auscname;
	private String auscdescription;
	private String auscnote;
}
