package org.AOOPProject;

import java.io.File;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class utils {
    static private String convertGlobToRegEx(String line) {
        String trimmedLine = line.trim();
        int strLen = trimmedLine.length();
        StringBuilder builder = new StringBuilder(strLen);
        if (trimmedLine.startsWith("*")) {
            trimmedLine = trimmedLine.substring(1);
            strLen--;
        }
        if (trimmedLine.endsWith("*")) {
            trimmedLine = trimmedLine.substring(0, strLen - 1);
            strLen--;
        }
        boolean escaping = false;
        int inCurlies = 0;
        for (char currentChar : trimmedLine.toCharArray()) {
            switch (currentChar) {
                case '*':
                    if (escaping)
                        builder.append("\\*");
                    else
                        builder.append(".*");
                    escaping = false;
                    break;
                case '?':
                    if (escaping)
                        builder.append("\\?");
                    else
                        builder.append('.');
                    escaping = false;
                    break;
                case '.':
                case '(':
                case ')':
                case '+':
                case '|':
                case '^':
                case '$':
                case '@':
                case '%':
                    builder.append('\\');
                    builder.append(currentChar);
                    escaping = false;
                    break;
                case '\\':
                    if (escaping) {
                        builder.append("\\\\");
                        escaping = false;
                    } else
                        escaping = true;
                    break;
                case '{':
                    if (escaping) {
                        builder.append("\\{");
                    } else {
                        builder.append('(');
                        inCurlies++;
                    }
                    escaping = false;
                    break;
                case '}':
                    if (inCurlies > 0 && !escaping) {
                        builder.append(')');
                        inCurlies--;
                    } else if (escaping)
                        builder.append("\\}");
                    else
                        builder.append("}");
                    escaping = false;
                    break;
                case ',':
                    if (inCurlies > 0 && !escaping) {
                        builder.append('|');
                    } else if (escaping)
                        builder.append("\\,");
                    else
                        builder.append(",");
                    break;
                default:
                    escaping = false;
                    builder.append(currentChar);
            }
        }
        return builder.toString();
    }

    static String getName(File file) {
        String name = file.getName();
        if (name.trim().length() == 0)
            name = file.getPath();
        return name;
    }

    static ColorUIResource getLAFDefaultColor(String key) {
        Object o = UIManager.getLookAndFeelDefaults().get(key);
        if (o instanceof ColorUIResource)
            return (ColorUIResource) o;
        return null;
    }

    static Object getLAFDefault(String key) {
        Object o = UIManager.getLookAndFeelDefaults().get(key);
        return o;
    }
}
