/*
 *  Copyright 2011, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */

package org.docx4j.openpackaging.parts.DrawingML;

import java.io.File;

import javax.xml.transform.Templates;
import javax.xml.transform.stream.StreamSource;

import org.docx4j.XmlUtils;
import org.docx4j.dml.diagram.CTDiagramDefinition;
import org.docx4j.openpackaging.io.SaveToZipFile;
import org.docx4j.openpackaging.packages.OpcPackage;
// import org.docx4j.openpackaging.packages.PresentationMLPackage;
import org.docx4j.openpackaging.parts.PartName;
// import org.docx4j.openpackaging.parts.PresentationML.MainPresentationPart;
// import org.docx4j.openpackaging.parts.PresentationML.SlideLayoutPart;
// import org.docx4j.openpackaging.parts.PresentationML.SlidePart;
import org.glox4j.openpackaging.packages.GloxPackage;
// import org.pptx4j.jaxb.Context;
// import org.pptx4j.model.SlideSizesWellKnown;
// import org.pptx4j.pml.CTGraphicalObjectFrame;
// import org.pptx4j.pml.Presentation;
import org.w3c.dom.Document;

public class CreatePptxWithSmartArt extends CreateWithSmartArtAbstract {

  public CreatePptxWithSmartArt(CTDiagramDefinition diagramLayoutObj,
      Templates layoutTreeCreatorXslt,
      Templates layoutTree2DiagramDataXslt) {

    super(diagramLayoutObj,
        layoutTreeCreatorXslt,
        layoutTree2DiagramDataXslt);
  }

  

  public static void main(String[] args) throws Exception {

    // Need the source doc as a DOM for later, and also
    // as XSLT input
    Document doc = XmlUtils.getNewDocumentBuilder().parse(
        new File(System.getProperty("user.dir") + "/sample-docs/glox/extracted/data-sample.xml"));

    GloxPackage gloxPackage = (GloxPackage) OpcPackage.load(
        new File(System.getProperty("user.dir") + "/sample-docs/glox/extracted/CirclePictureHierarchy.glox"));

    CTDiagramDefinition diagramLayoutObj = gloxPackage.getDiagramLayoutPart().getJaxbElement();

    Templates layoutTreeCreatorXslt = DiagramLayoutPart.generateLayoutTreeXSLT(
        diagramLayoutObj);

    Templates layoutTree2DiagramDataXslt = XmlUtils.getTransformerTemplate(
        new StreamSource(
            org.docx4j.utils.ResourceUtils.getResource(
                "org/docx4j/openpackaging/parts/DrawingML/DiagramLayoutTree4AlgHier.xslt")));

    CreatePptxWithSmartArt creatorPptx = new CreatePptxWithSmartArt(diagramLayoutObj, layoutTreeCreatorXslt,
        layoutTree2DiagramDataXslt);

    //PresentationMLPackage pkg = creatorPptx.createSmartArtPkg(SlideSizesWellKnown.A3, true, doc);

    //SaveToZipFile saver = new SaveToZipFile(pkg);
    //saver.save(new File(System.getProperty("user.dir") + "/OUT.pptx"));
    System.out.println("Done!");
  }
}
