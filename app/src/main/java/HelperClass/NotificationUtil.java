/**	 ObservationApp, Copyright 2016, University of Prince Edward Island,
 550 University Avenue, C1A4P3,
 Charlottetown, PE, Canada
 *
 * 	 @author Kent Li <zhuoli@upei.ca>
 *
 *   This file is part of ObservationApp.
 *
 *   ObservationApp is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   CycleTracks is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with CycleTracks.  If not, see <http://www.gnu.org/licenses/>.
 */
package HelperClass;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import ca.zhuoliupei.observationapp.LoginActivity;
import ca.zhuoliupei.observationapp.R;

/**
 * Created by zhuol on 3/16/2016.
 */
public class NotificationUtil {
    public enum NotificationID{
        SESSION_EXPIRED_NOTIFICATION_ID(0),
        UPLOADING_NOTIFICATION_ID(1),
        UPLOAD_FAILED_NOTIFICATION_ID(2),
        UPDATE_USER_PROFILE_IMAGE_NOTIFICATION_ID(3),
        UPDATE_USER_PROFILE_NAME_NOTIFICATION_ID(4),
        UPDATE_USER_PROFILE_ADDRESS_NOTIFICATION_ID(5),
        DELETE_USER_POST_NOTIFICATION_ID(6);

        private final int id;
        private NotificationID(int id){
            this.id=id;
        }
        public int getID(){
            return id;
        }
    }
    public static void showNotification(Context context,NotificationID NOTIFICATION_ID){
        int iconSrcID = R.drawable.icon_upload;
        String title="";
        String text="";
        Intent resultIntent=null;
        switch (NOTIFICATION_ID){
            case SESSION_EXPIRED_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_expired;
                title=context.getString(R.string.sessionExpiredNotificationTitle);
                text=context.getString(R.string.sessionExpiredNotificationText);
                resultIntent=new Intent(context,LoginActivity.class);
                break;
            }
            case UPLOAD_FAILED_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_failed;
                title=context.getString(R.string.uploadFailedNotificationTitle);
                text=context.getString(R.string.uploadFailedNotificationText);
                break;
            }
            case UPLOADING_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_upload;
                title=context.getString(R.string.uploadingNotificationTitle);
                text=context.getString(R.string.uploadingNotificationText);
                break;
            }
            case UPDATE_USER_PROFILE_IMAGE_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_upload;
                title=context.getString(R.string.updatingNotificationTitle);
                text=context.getString(R.string.updatingUserImageNotificationText);
                break;
            }
            case UPDATE_USER_PROFILE_NAME_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_upload;
                title=context.getString(R.string.updatingNotificationTitle);
                text=context.getString(R.string.updatingUserNameNotificationText);
                break;
            }
            case UPDATE_USER_PROFILE_ADDRESS_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_upload;
                title=context.getString(R.string.updatingNotificationTitle);
                text=context.getString(R.string.updatingUserAddressNotificationText);
                break;
            }
            case DELETE_USER_POST_NOTIFICATION_ID:{
                iconSrcID=R.drawable.icon_upload;
                title=context.getString(R.string.deletingNotificationTitle);
                text=context.getString(R.string.deletingUserPostNotificationText);
            }
        }
        NotificationCompat.Builder mBuilder=
                new NotificationCompat.Builder(context) .
                        setSmallIcon(iconSrcID).
                        setContentTitle(title).
                        setContentText(text);

        if (resultIntent!=null) {
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
        }
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID.getID(),mBuilder.build());
    }

    public static void removeNotification(Context context,NotificationID notificationID){
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) context.getApplicationContext().getSystemService(ns);
        nMgr.cancel(notificationID.getID());
    }
}
