/*
 *******************************************************************************
 * Copyright (C) 1998-2003, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 *
 * Created on Dec 3, 2003
 *
 * $Source: /xsrl/Nsvn/icu/icu4j/src/com/ibm/icu/dev/tool/layout/LookupList.java,v $
 * $Date: 2003/12/09 01:18:12 $
 * $Revision: 1.1 $
 * 
 *******************************************************************************
 */
package com.ibm.icu.dev.tool.layout;

import java.io.*;
import java.util.*;
import java.lang.*;

public class LookupList
{
    private Lookup[] lookups;
    private int lookupCount;
    
    public LookupList()
    {
        lookups = new Lookup[10];
        lookupCount = 0;
    }
    
    public int addLookup(Lookup lookup)
    {
        if (lookupCount >= lookups.length) {
            Lookup[] newLookups = new Lookup[lookups.length + 5];
            
            System.arraycopy(lookups, 0, newLookups, 0, lookups.length);
            lookups = newLookups;
        }
        
        lookups[lookupCount] = lookup;
        
        return lookupCount++;
    }
    
    public void writeLookupList(OpenTypeTableWriter writer)
    {
        System.out.println("writing lookup list...");
        
        int lookupListBase = writer.getOutputIndex();
        
        writer.writeData(lookupCount);
        
        int lookupOffset = writer.getOutputIndex();
        
        for (int i = 0; i < lookupCount; i += 1) {
            writer.writeData(0); // Offset to lookup (fixed later);
        }
        
        for (int i = 0; i < lookupCount; i += 1) {
            writer.fixOffset(lookupOffset++, lookupListBase);
            lookups[i].writeLookup(writer);
        }
    }
}