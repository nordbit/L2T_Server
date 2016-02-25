/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package l2server.gameserver.handler;

import java.util.HashMap;
import java.util.Map;

import l2server.gameserver.templates.skills.L2SkillTargetType;
import l2server.log.Log;

/**
 * @author Max
 */
public class SkillTargetTypeHandler
{
	private Map<Enum<L2SkillTargetType>, ISkillTargetTypeHandler> _datatable;
	
	public static SkillTargetTypeHandler getInstance()
	{
		return SingletonHolder._instance;
	}
	
	private SkillTargetTypeHandler()
	{
		_datatable = new HashMap<Enum<L2SkillTargetType>, ISkillTargetTypeHandler>();
	}
	
	public void registerSkillTargetType(ISkillTargetTypeHandler handler)
	{
		Enum<L2SkillTargetType> ids = handler.getTargetType();
		_datatable.put(ids, handler);
	}
	
	public ISkillTargetTypeHandler getSkillTarget(Enum<L2SkillTargetType> skillTargetType)
	{
		Enum<L2SkillTargetType> target = skillTargetType;
		
		Log.fine("getting handler for command: " + target.toString() + " -> " + (_datatable.get(target) != null));
		return _datatable.get(target);
	}
	
	/**
	 * @return
	 */
	public int size()
	{
		return _datatable.size();
	}
	
	@SuppressWarnings("synthetic-access")
	private static class SingletonHolder
	{
		protected static final SkillTargetTypeHandler _instance = new SkillTargetTypeHandler();
	}
}