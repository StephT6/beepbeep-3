/*
    BeepBeep, an event stream processor
    Copyright (C) 2008-2015 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.cep.ltl;

import java.util.Stack;

import ca.uqac.lif.cep.Connector;
import ca.uqac.lif.cep.Connector.ConnectorException;
import ca.uqac.lif.cep.FunctionProcessor;
import ca.uqac.lif.cep.Processor;

public class Not extends FunctionProcessor 
{
	public Not()
	{
		super(Troolean.NOT_FUNCTION);
	}
	
	public static void build(Stack<Object> stack) throws ConnectorException 
	{
		stack.pop(); // (
		Processor p = (Processor) stack.pop();
		stack.pop(); // )
		stack.pop(); // NOT
		Not op = new Not();
		Connector.connect(p, op);
		stack.push(op);
	}
	
	@Override
	public Not clone()
	{
		return new Not();
	}
}
