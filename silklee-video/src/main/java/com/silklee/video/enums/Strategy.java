package com.silklee.video.enums;

public enum Strategy {
    FAST {
        @Override
        public void exportData(String param) {
            System.out.println("test fast" + param);
        }
    },

    NORMAL {
        @Override
        public void exportData(String param) {
            System.out.println("test normal" + param);
        }
    },

    SMOOTH {
        @Override
        public void exportData(String param) {
            System.out.println("test smooth" + param);
        }
    };

    public abstract void exportData(String param);
}
