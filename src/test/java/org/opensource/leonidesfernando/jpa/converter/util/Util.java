package org.opensource.leonidesfernando.jpa.converter.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class Util {

    public static final DateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("pt", "BR"));
}
