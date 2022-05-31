/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.axis2.databinding.utils;

import junit.framework.TestCase;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.axiom.om.util.Base64;

public class ConverterUtilTest extends TestCase {

    /** Test conversion of Big Integer */
    public void testBigInteger() {
        List l = new ArrayList();
        l.add("23445");
        l.add("23446");
        l.add("23456646");
        l.add("1113646");

        Object convertedObj = ConverterUtil.convertToArray(
                BigInteger.class, l);

        assertTrue(convertedObj.getClass().isArray());
        assertTrue(convertedObj.getClass().equals(BigInteger[].class));

    }

    /** integer arrays */
    public void testInt() {
        List l = new ArrayList();
        l.add("23445");
        l.add("23446");
        l.add("23456646");
        l.add("1113646");

        Object convertedObj = ConverterUtil.convertToArray(
                int.class, l);

        assertTrue(convertedObj.getClass().isArray());
        assertTrue(convertedObj.getClass().equals(int[].class));

    }

    /** boolean arrays */
    public void testBool() {
        List l = new ArrayList();
        l.add("true");
        l.add("false");
        l.add("true");
        l.add("false");

        Object convertedObj = ConverterUtil.convertToArray(
                boolean.class, l);

        assertTrue(convertedObj.getClass().isArray());
        assertTrue(convertedObj.getClass().equals(boolean[].class));

    }

    public void testConvertToDateTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Calendar calendar;

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29");
        System.out.println("String   ==> " + "2007-02-15T14:54:29");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29.399");
        System.out.println("String   ==> " + "2007-02-15T14:54:29.399");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29+05:30");
        System.out.println("String   ==> " + "2007-02-15T14:54:29+05:30");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29.399+05:30");
        System.out.println("String   ==> " + "2007-02-15T14:54:29.399+05:30");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29Z");
        System.out.println("String   ==> " + "2007-02-15T14:54:29Z");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29.399Z");
        System.out.println("String   ==> " + "2007-02-15T14:54:29.399Z");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2006-12-11T23:57:16.625Z");
        System.out.println("String   ==> " + "2006-12-11T23:57:16.625Z");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

        calendar = ConverterUtil.convertToDateTime("2007-02-15T14:54:29.399-05:30");
        System.out.println("String   ==> " + "2007-02-15T14:54:29.399-05:30");
        System.out.println("calendar ==> " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(calendar));

    }

    public void testConvertToDateString() {
        Date date = new Date();
        String dateString = ConverterUtil.convertToString(date);
        System.out.println("Date ==> " + dateString);
    }

    public void testConvertToDate() {

        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddZ");
        date = ConverterUtil.convertToDate("2007-02-15");
        System.out.println("String   ==> " + "2007-02-15");
        System.out.println("calendar ==> " + simpleDateFormat.format(date));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(date));

        date = ConverterUtil.convertToDate("2007-02-15Z");
        System.out.println("String   ==> " + "2007-02-15Z");
        System.out.println("calendar ==> " + simpleDateFormat.format(date));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(date));

        date = ConverterUtil.convertToDate("2007-02-15+05:30");
        System.out.println("String   ==> " + "2007-02-15+05:30");
        System.out.println("calendar ==> " + simpleDateFormat.format(date));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(date));

        date = ConverterUtil.convertToDate("2007-02-15-12:30");
        System.out.println("String   ==> " + "2007-02-15-12:30");
        System.out.println("calendar ==> " + simpleDateFormat.format(date));
        System.out.println("calendar ==> " + ConverterUtil.convertToString(date));

    }

    public void testConvertCalendarToString() {
        
        TimeZone timeZone = TimeZone.getTimeZone("Australia/Perth");
        Calendar c = Calendar.getInstance(timeZone);
        c.clear();
        c.set(2008, Calendar.JANUARY, 1);
        TestCase.assertTrue(ConverterUtil.convertToString(c).endsWith("+09:00"));
        
    }
    
    public void testconvertToDateXML() {

        Date date = null;
        String dateStr = null;

        dateStr = "2007-02-15";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "2007-02-15Z";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "2007-02-15+05:30";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "2007-02-15-12:30";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "1997-07-16T19:20:30.45+01:00";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "2011-09-27T14:43:55.162+05:30";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "1997-07-16T19:20:30+01:00";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

        dateStr = "1994-11-05T13:15:30Z";
        date = ConverterUtil.convertXmlToDate(dateStr);
        assertNotNull(date);

    }
    
	public void testConvertToStringFromDataHandler() {
		String inStr = "Sample Data";
		DataSource ds = new ByteArrayDataSource(inStr.getBytes());
		DataHandler dh = new DataHandler(ds);
		String rawOutStr = ConverterUtil.convertToString(dh);
		String outStr = new String(Base64.decode(rawOutStr));
		assertEquals("Not expected content", inStr, outStr);
	}
}
