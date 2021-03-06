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

package ims.ocrr.vo.beans;

public class PhlebotomyRoundVoBean extends ims.vo.ValueObjectBean
{
	public PhlebotomyRoundVoBean()
	{
	}
	public PhlebotomyRoundVoBean(ims.ocrr.vo.PhlebotomyRoundVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.collector = vo.getCollector() == null ? null : (ims.core.vo.beans.HcpBean)vo.getCollector().getBean();
		this.wards = vo.getWards() == null ? null : vo.getWards().getBeanCollection();
		this.roundtocollect = vo.getRoundToCollect() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoundToCollect().getBean();
		this.collectionitems = vo.getCollectionItems() == null ? null : vo.getCollectionItems().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PhlebotomyRoundVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.date = vo.getDate() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDate().getBean();
		this.collector = vo.getCollector() == null ? null : (ims.core.vo.beans.HcpBean)vo.getCollector().getBean(map);
		this.wards = vo.getWards() == null ? null : vo.getWards().getBeanCollection();
		this.roundtocollect = vo.getRoundToCollect() == null ? null : (ims.vo.LookupInstanceBean)vo.getRoundToCollect().getBean();
		this.collectionitems = vo.getCollectionItems() == null ? null : vo.getCollectionItems().getBeanCollection();
	}

	public ims.ocrr.vo.PhlebotomyRoundVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PhlebotomyRoundVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PhlebotomyRoundVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PhlebotomyRoundVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PhlebotomyRoundVo();
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
	public ims.framework.utils.beans.DateBean getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.beans.DateBean value)
	{
		this.date = value;
	}
	public ims.core.vo.beans.HcpBean getCollector()
	{
		return this.collector;
	}
	public void setCollector(ims.core.vo.beans.HcpBean value)
	{
		this.collector = value;
	}
	public ims.core.vo.beans.LocationLiteVoBean[] getWards()
	{
		return this.wards;
	}
	public void setWards(ims.core.vo.beans.LocationLiteVoBean[] value)
	{
		this.wards = value;
	}
	public ims.vo.LookupInstanceBean getRoundToCollect()
	{
		return this.roundtocollect;
	}
	public void setRoundToCollect(ims.vo.LookupInstanceBean value)
	{
		this.roundtocollect = value;
	}
	public ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] getCollectionItems()
	{
		return this.collectionitems;
	}
	public void setCollectionItems(ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] value)
	{
		this.collectionitems = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateBean date;
	private ims.core.vo.beans.HcpBean collector;
	private ims.core.vo.beans.LocationLiteVoBean[] wards;
	private ims.vo.LookupInstanceBean roundtocollect;
	private ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] collectionitems;
}
