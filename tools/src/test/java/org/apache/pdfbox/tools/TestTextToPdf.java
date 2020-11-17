/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.StringReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

/**
 * Test suite for TextToPDF.
 */
public class TestTextToPdf
{
    /**
     * This test ensures that a PDF created from an empty String is still readable by Adobe Reader
     */
    @Test
    public void testCreateEmptyPdf() throws Exception
    {
        TextToPDF pdfCreator = new TextToPDF();
        PDDocument pdfDoc;
        try (StringReader reader = new StringReader(""))
        {
            pdfDoc = pdfCreator.createPDFFromText(reader);
        }

        // In order for the PDF document to be openable by Adobe Reader, it needs
        // to have some pages in it. So we'll check that.
        int pageCount = pdfDoc.getNumberOfPages();
        assertNotNull(pageCount, "All Pages was unexpectedly zero.");
        assertEquals(1, pageCount, "Wrong number of pages.");
        pdfDoc.close();
    }
}
