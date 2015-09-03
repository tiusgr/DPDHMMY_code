/*
 * Copyright  2001-2002,2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.tools.ant.taskdefs.condition;

import org.apache.tools.ant.BuildException;

/**
 * &lt;not&gt; condition.
 *
 * Evaluates to true if the single condition nested into it is false
 * and vice versa.
 *
 * @since Ant 1.4
 * @version $Revision: 1.6.2.4 $
 */
public class Not extends ConditionBase implements Condition {

    /**
     * Evaluate condition
     *
     * @return true if the condition is true.
     * @throws BuildException if the condition is not configured correctly.
     */
    public boolean eval() throws BuildException {
        if (countConditions() > 1) {
            throw new BuildException("You must not nest more than one "
                + "condition into <not>");
        }
        if (countConditions() < 1) {
            throw new BuildException("You must nest a condition into <not>");
        }
        return !((Condition) getConditions().nextElement()).eval();
    }

}
