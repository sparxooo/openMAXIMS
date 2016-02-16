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

package ims.assessment.vo.beans;

public class GraphicAssessmentFindingVoBean extends ims.vo.ValueObjectBean
{
	public GraphicAssessmentFindingVoBean()
	{
	}
	public GraphicAssessmentFindingVoBean(ims.assessment.vo.GraphicAssessmentFindingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.finding = vo.getFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getFinding().getBean();
		this.sequence = vo.getSequence();
		this.findingstage = vo.getFindingStage() == null ? null : vo.getFindingStage().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.GraphicAssessmentFindingVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.finding = vo.getFinding() == null ? null : (ims.core.vo.beans.DrawingGraphicFindingVoBean)vo.getFinding().getBean(map);
		this.sequence = vo.getSequence();
		this.findingstage = vo.getFindingStage() == null ? null : vo.getFindingStage().getBeanCollection();
	}

	public ims.assessment.vo.GraphicAssessmentFindingVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.assessment.vo.GraphicAssessmentFindingVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.GraphicAssessmentFindingVo vo = null;
		if(map != null)
			vo = (ims.assessment.vo.GraphicAssessmentFindingVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.assessment.vo.GraphicAssessmentFindingVo();
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
	public ims.core.vo.beans.DrawingGraphicFindingVoBean getFinding()
	{
		return this.finding;
	}
	public void setFinding(ims.core.vo.beans.DrawingGraphicFindingVoBean value)
	{
		this.finding = value;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.sequence = value;
	}
	public ims.assessment.vo.beans.FindingStageQuestionsVoBean[] getFindingStage()
	{
		return this.findingstage;
	}
	public void setFindingStage(ims.assessment.vo.beans.FindingStageQuestionsVoBean[] value)
	{
		this.findingstage = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.DrawingGraphicFindingVoBean finding;
	private Integer sequence;
	private ims.assessment.vo.beans.FindingStageQuestionsVoBean[] findingstage;
}