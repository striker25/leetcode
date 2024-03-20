package com.striker25.strings.tagcontentextractor;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

  public static void main(String[] args) {

    String[] lines = {
        "<h1>Nayeem loves counseling</h1>",
        "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>", // esta no funciona
        "<Amee>safat codes like a ninja</amee>",
        "<SA premium>Imtiaz has a secret crush</SA premium>"
    };

    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());
    while (testCases > 0) {
      String line = in.nextLine();

      //Write your code here

      Pattern pattern = Pattern.compile("(<[^/][^>]*>)");
      Matcher matcher = pattern.matcher(line);

      int matches = 0;

      while (matcher.find()) {
        matches++;

        Tag tag = new Tag();

        String tagStr = matcher.group()
            .replace("<", "")
            .replace(">", "");
        tag.setTag(tagStr);
        tag.setStartPosition(matcher.start());
        tag.setHasClosingTag(false);

        String closingTag = "</" + tagStr + ">";
        // closing tag must be after the opening tag
        // so make a substring of the line

        String lineSubstring = line.substring(tag.getEndPosition());

        if (lineSubstring.contains(closingTag)) {
          tag.setHasClosingTag(true);

          // get the position of the closing tag
          int closingTagPosition = lineSubstring.indexOf(closingTag);
          tag.setExtractedContent(lineSubstring.substring(0, closingTagPosition));
        }

        // search for the closing tag
        int closingTagPosition = lineSubstring.indexOf(closingTag);
        if (closingTagPosition >= 0) {
          tag.setHasClosingTag(true);
        }

        String openTag = "<" + tagStr + ">";
        String content = tag.getExtractedContent();
        if (Objects.nonNull(content) && tag.isHasClosingTag() && !content.contains(openTag)
            && !content.contains(closingTag)) {
          System.out.println(tag.getExtractedContent());
        } else if (Objects.nonNull(content) && tag.isHasClosingTag() && content.contains(openTag)) {
          // nothing
        } else {
          System.out.println("None");
        }
      }

      // if there are no matches, return none
      if (matches == 0) {
        System.out.println("None");
      }

      testCases--;
    }
  }



    /*for (String line : lines) {
      Pattern pattern = Pattern.compile("(<[^/][^>]*>)");
      Matcher matcher = pattern.matcher(line);

      int matches = 0;

      while (matcher.find()) {
        matches++;

        Tag tag = new Tag();

        String tagStr = matcher.group()
            .replace("<", "")
            .replace(">", "");
        tag.setTag(tagStr);
        tag.setStartPosition(matcher.start());
        tag.setHasClosingTag(false);

        String closingTag = "</" + tagStr + ">";
        // closing tag must be after the opening tag
        // so make a substring of the line

        String lineSubstring = line.substring(tag.getEndPosition());

        if (lineSubstring.contains(closingTag)) {
          tag.setHasClosingTag(true);

          // get the position of the closing tag
          int closingTagPosition = lineSubstring.indexOf(closingTag);
          tag.setExtractedContent(lineSubstring.substring(0, closingTagPosition));
        }

        // search for the closing tag
        int closingTagPosition = lineSubstring.indexOf(closingTag);
        if (closingTagPosition >= 0) {
          tag.setHasClosingTag(true);
        }

        String openTag = "<" + tagStr + ">";
        String content = tag.getExtractedContent();
        if (Objects.nonNull(content) && tag.isHasClosingTag() && !content.contains(openTag)
            && !content.contains(closingTag)) {
          System.out.println(tag.getExtractedContent());
        } else if (Objects.nonNull(content) && tag.isHasClosingTag() && content.contains(openTag)) {
          // nothing
        } else {
          System.out.println("None");
        }
      }

      // if there are no matches, return none
      if (matches == 0) {
        System.out.println("None");
      }
    }*/

  public static class Tag {

    private String tag;
    private int startPosition;

    private boolean hasClosingTag;

    private String extractedContent;

    public String getExtractedContent() {
      return extractedContent;
    }

    public void setExtractedContent(String extractedContent) {
      this.extractedContent = extractedContent;
    }

    public int getEndPosition() {
      return startPosition + tag.length() + 2;
    }

    public String getTag() {
      return tag;
    }

    public void setTag(String tag) {
      this.tag = tag;
    }

    public int getStartPosition() {
      return startPosition;
    }

    public void setStartPosition(int startPosition) {
      this.startPosition = startPosition;
    }

    public boolean isHasClosingTag() {
      return hasClosingTag;
    }

    public void setHasClosingTag(boolean hasClosingTag) {
      this.hasClosingTag = hasClosingTag;
    }

    @Override
    public String toString() {
      return "Tag{" +
          "tag='" + tag + '\'' +
          ", startPosition=" + startPosition +
          ", hasClosingTag=" + hasClosingTag +
          ", extractedContent='" + extractedContent + '\'' +
          '}';
    }
  }
}



