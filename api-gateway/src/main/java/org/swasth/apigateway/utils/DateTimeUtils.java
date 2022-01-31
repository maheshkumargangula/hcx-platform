package org.swasth.apigateway.utils;

import org.swasth.apigateway.exception.ClientException;
import org.swasth.apigateway.exception.ErrorCodes;
import org.joda.time.DateTime;

public class DateTimeUtils {

    public static boolean validTimestamp(int range, String timestamp) throws ClientException {
        try {
            DateTime requestTime = new DateTime(timestamp);
            DateTime currentTime = DateTime.now();
            return (!requestTime.isBefore(currentTime.minusHours(range)) && !requestTime.isAfter(currentTime));
        } catch (Exception e) {
            throw new ClientException(ErrorCodes.CLIENT_ERR_INVALID_TIMESTAMP, "Timestamp should be a valid ISO-8061 format, " + "Exception msg: " + e.getMessage());
        }
    }

}