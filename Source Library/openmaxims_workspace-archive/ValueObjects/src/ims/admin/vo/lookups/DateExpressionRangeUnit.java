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

package ims.admin.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class DateExpressionRangeUnit extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public DateExpressionRangeUnit()
	{
		super();
	}
	public DateExpressionRangeUnit(int id)
	{
		super(id, "", true);
	}
	public DateExpressionRangeUnit(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public DateExpressionRangeUnit(int id, String text, boolean active, DateExpressionRangeUnit parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public DateExpressionRangeUnit(int id, String text, boolean active, DateExpressionRangeUnit parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public DateExpressionRangeUnit(int id, String text, boolean active, DateExpressionRangeUnit parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static DateExpressionRangeUnit buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new DateExpressionRangeUnit(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (DateExpressionRangeUnit)super.getParentInstance();
	}
	public DateExpressionRangeUnit getParent()
	{
		return (DateExpressionRangeUnit)super.getParentInstance();
	}
	public void setParent(DateExpressionRangeUnit parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		DateExpressionRangeUnit[] typedChildren = new DateExpressionRangeUnit[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (DateExpressionRangeUnit)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof DateExpressionRangeUnit)
		{
			super.addChild((DateExpressionRangeUnit)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof DateExpressionRangeUnit)
		{
			super.removeChild((DateExpressionRangeUnit)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		DateExpressionRangeUnitCollection result = new DateExpressionRangeUnitCollection();
		result.add(DAY);
		result.add(MONTH);
		result.add(YEAR);
		result.add(WEEK);
		return result;
	}
	public static DateExpressionRangeUnit[] getNegativeInstances()
	{
		DateExpressionRangeUnit[] instances = new DateExpressionRangeUnit[4];
		instances[0] = DAY;
		instances[1] = MONTH;
		instances[2] = YEAR;
		instances[3] = WEEK;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[4];
		negativeInstances[0] = "DAY";
		negativeInstances[1] = "MONTH";
		negativeInstances[2] = "YEAR";
		negativeInstances[3] = "WEEK";
		return negativeInstances;
	}
	public static DateExpressionRangeUnit getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static DateExpressionRangeUnit getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		DateExpressionRangeUnit[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1031004;
	public static final DateExpressionRangeUnit DAY = new DateExpressionRangeUnit(-648, "Day", true, null, null, Color.FireBrick);
	public static final DateExpressionRangeUnit MONTH = new DateExpressionRangeUnit(-649, "Month", true, null, null, Color.ForestGreen);
	public static final DateExpressionRangeUnit YEAR = new DateExpressionRangeUnit(-650, "Year", true, null, null, Color.Fuchia);
	public static final DateExpressionRangeUnit WEEK = new DateExpressionRangeUnit(-651, "Week", true, null, null, Color.HoneyDue);
}