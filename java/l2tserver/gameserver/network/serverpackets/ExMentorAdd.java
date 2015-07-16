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
package l2tserver.gameserver.network.serverpackets;

import l2tserver.gameserver.model.actor.instance.L2PcInstance;

/**
 *
 * @author Erlandys
 */
public class ExMentorAdd extends L2GameServerPacket
{
	L2PcInstance _player;
	public ExMentorAdd(L2PcInstance activeChar)
	{
		_player = activeChar;
	}

	@Override
	protected void writeImpl()
	{
		writeC(0xFE);
		writeH(0x11c);
		writeS(_player.getName());
		writeD(_player.getClassId());
		writeD(_player.getLevel());
	}

	@Override
	public String getType()
	{
		return null;
	}
	
}