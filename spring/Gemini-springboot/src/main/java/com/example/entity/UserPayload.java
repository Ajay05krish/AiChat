package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class UserPayload {

    private List<Content> contents = new ArrayList<>();

    public UserPayload(String text) {
        Content content = new Content();
        Part part = new Part();
        part.setText(text);

        List<Part> parts = new ArrayList<>();
        parts.add(part);

        content.setParts(parts);

        this.contents.add(content);
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public static class Content {
        private List<Part> parts;

        public List<Part> getParts() {
            return parts;
        }

        public void setParts(List<Part> parts) {
            this.parts = parts;
        }
    }

    public static class Part {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}