package com.hexa.app.domain.util;

public class Constants {

    public enum ErrorMessage {
        ERROR_GETTING_DATA("error.get.message"),
        ERROR_SAVING_DATA("error.save.message"),
        ERROR_DELETE_DATA("error.delete.message"),
        ERROR_UPDATE_DATA("error.update.message"),
        ERROR_GETID_DATA("error.getid.message");

        private String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }


    }



}
