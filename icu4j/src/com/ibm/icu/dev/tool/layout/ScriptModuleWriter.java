/*
 *******************************************************************************
 * Copyright (C) 1998-2003, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 *
 * $Source: /xsrl/Nsvn/icu/icu4j/src/com/ibm/icu/dev/tool/layout/ScriptModuleWriter.java,v $
 * $Date: 2003/12/09 01:18:11 $
 * $Revision: 1.4 $
 *
 *******************************************************************************
 */
package com.ibm.icu.dev.tool.layout;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScriptModuleWriter extends ModuleWriter
{
    public ScriptModuleWriter(ScriptData theScriptData, LanguageData theLanguageData)
    {
        super();
        
        scriptData = theScriptData;
        languageData = theLanguageData;
    }

    protected ScriptData scriptData;
    protected LanguageData languageData;
}