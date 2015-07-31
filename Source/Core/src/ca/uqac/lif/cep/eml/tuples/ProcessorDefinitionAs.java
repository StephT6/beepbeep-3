/*
    BeepBeep, an event stream processor
    Copyright (C) 2008-2015 Sylvain Hallé

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.cep.eml.tuples;

import java.util.Stack;

import ca.uqac.lif.cep.Processor;

public class ProcessorDefinitionAs extends ProcessorDefinition
{
	protected String m_processorName;
	
	protected Processor m_processor;
	
	public ProcessorDefinitionAs()
	{
		super();
	}

	@Override
	public void build(Stack<Object> stack)
	{
		EmlString name = (EmlString) stack.pop();
		Processor proc = null;
		stack.pop(); // AS
		Object o = stack.peek();
		if (o instanceof String && ((String)o).compareTo(")") == 0)
		{
			// We are in the case where there are
			// parentheses around the processor
			stack.pop(); // )
			proc = (Processor) stack.pop();
			stack.pop(); // (
		}
		else
		{
			proc = (Processor) stack.pop();
		}
		m_processorName = name.stringValue();
		m_processor = proc;
		stack.push(this);
	}
}