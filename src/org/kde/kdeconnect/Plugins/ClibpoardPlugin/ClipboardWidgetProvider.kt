package org.kde.kdeconnect.Plugins.ClibpoardPlugin

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.res.Configuration
import android.util.TypedValue
import android.widget.RemoteViews
import androidx.core.content.ContextCompat
import org.kde.kdeconnect_tp.BuildConfig
import org.kde.kdeconnect_tp.R

class ClipboardWidgetProvider : AppWidgetProvider()
{

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for(appWidgetId in appWidgetIds) {
            val v = RemoteViews(BuildConfig.APPLICATION_ID, R.layout.send_clipboard_widget_layout)

            val sendClipboardIntent = ClipboardFloatingActivity.getIntent(context, true)
            val sendClipboardPendingIntent = PendingIntent.getActivity(
                context,
                14,
                sendClipboardIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)
            v.setOnClickPendingIntent(R.id.widget_button, sendClipboardPendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, v)
        }
    }
}