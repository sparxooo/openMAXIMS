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

package ims.clinical.vo.beans;

public class VTMVoBean extends ims.vo.ValueObjectBean
{
	public VTMVoBean()
	{
	}
	public VTMVoBean(ims.clinical.vo.VTMVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.invalid = vo.getInvalid();
		this.name = vo.getName();
		this.abbreviatedname = vo.getAbbreviatedName();
		this.moietyidentifier = vo.getMoietyIdentifier();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.VTMVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.invalid = vo.getInvalid();
		this.name = vo.getName();
		this.abbreviatedname = vo.getAbbreviatedName();
		this.moietyidentifier = vo.getMoietyIdentifier();
	}

	public ims.clinical.vo.VTMVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.VTMVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.VTMVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.VTMVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.VTMVo();
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
	public Boolean getInvalid()
	{
		return this.invalid;
	}
	public void setInvalid(Boolean value)
	{
		this.invalid = value;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String value)
	{
		this.name = value;
	}
	public String getAbbreviatedName()
	{
		return this.abbreviatedname;
	}
	public void setAbbreviatedName(String value)
	{
		this.abbreviatedname = value;
	}
	public String getMoietyIdentifier()
	{
		return this.moietyidentifier;
	}
	public void setMoietyIdentifier(String value)
	{
		this.moietyidentifier = value;
	}

	private Integer id;
	private int version;
	private Boolean invalid;
	private String name;
	private String abbreviatedname;
	private String moietyidentifier;
}