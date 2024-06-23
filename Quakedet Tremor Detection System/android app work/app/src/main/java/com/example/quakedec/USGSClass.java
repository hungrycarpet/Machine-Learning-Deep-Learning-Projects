package com.example.quakedec;

public class USGSClass {
    String usgsIntroOne ="The United States Geological Survey (USGS, formerly simply Geological Survey) is a scientific agency of the United States government. The scientists of the USGS study the landscape of the United States, its natural resources, and the natural hazards that threaten it. The organization's work spans the disciplines of biology, geography, geology, and hydrology. The USGS is a fact-finding research organization with no regulatory responsibility.";
    String usgsIntrotwo ="Prompted by a report from the National Academy of Sciences, the USGS was created, by a last-minute amendment, to an act of Congress on March 3, 1879. It was charged with the \"classification of the public lands, and examination of the geological structure, mineral resources, and products of the national domain\". This task was driven by the need to inventory the vast lands added to the United States by the Louisiana Purchase in 1803 and the Mexican–American War in 1848.\n" +
            "\n" +
            "The legislation also provided that the Hayden, Powell, and Wheeler surveys be discontinued as of June 30, 1879." +
            "\n" +
            "Clarence King, the first director of USGS, assembled the new organization from disparate regional survey agencies. After a short tenure, King was succeeded in the director's chair by John Wesley Powell.";
    public  String getIntroduction() {

        return this.usgsIntroOne;
    }

    public String getBody() {
        return this.usgsIntrotwo;
    }
}
