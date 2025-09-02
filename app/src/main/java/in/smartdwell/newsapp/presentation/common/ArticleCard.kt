package `in`.smartdwell.newsapp.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import `in`.smartdwell.newsapp.R
import `in`.smartdwell.newsapp.domain.model.Article
import `in`.smartdwell.newsapp.presentation.Dimens.SmallIconSize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    // Format the date
    val formattedDate = formatDate(article.publishedAt)

    // Theme-aware colors
    val titleColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val bodyColor = if (isSystemInDarkTheme())
        Color.White.copy(alpha = 0.7f)
    else Color(0xFF4E4B66)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSystemInDarkTheme())
                Color(0xFF2C2C2C)
            else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Article Image
            AsyncImage(
                modifier = Modifier
                    .size(width = 120.dp, height = 90.dp)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(context)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_placeholder) // Add placeholder if you have one
                    .error(R.drawable.ic_error) // Add error image if you have one
                    .build(),
                contentDescription = "Article image",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Article Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Article Title
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = titleColor,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium
                )

                // Source and Date Info
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Source Name
                    Text(
                        text = article.source.name,
                        style = MaterialTheme.typography.labelSmall,
                        color = bodyColor,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Date with Icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_time),
                            contentDescription = "Published time",
                            modifier = Modifier.size(12.dp),
                            tint = bodyColor
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = formattedDate,
                            style = MaterialTheme.typography.labelSmall,
                            color = bodyColor
                        )
                    }
                }
            }
        }
    }
}

// Extension function to format date
private fun formatDate(dateString: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        val date = inputFormat.parse(dateString)
        outputFormat.format(date ?: Date())
    } catch (e: Exception) {
        // Fallback for different date formats
        try {
            val inputFormat2 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            val date = inputFormat2.parse(dateString)
            outputFormat.format(date ?: Date())
        } catch (e2: Exception) {
            // If all parsing fails, return a truncated version
            dateString.take(10) // Just return the date part
        }
    }
}

// Alternative: More compact card version
@Composable
fun CompactArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val formattedDate = formatDate(article.publishedAt)

    val titleColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val bodyColor = if (isSystemInDarkTheme())
        Color.White.copy(alpha = 0.7f)
    else Color(0xFF4E4B66)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        // Article Image
        AsyncImage(
            modifier = Modifier
                .size(80.dp)
                .clip(MaterialTheme.shapes.small),
            model = ImageRequest.Builder(context)
                .data(article.urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = "Article image",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Article Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodySmall,
                color = titleColor,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Medium
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall,
                    color = bodyColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(10.dp),
                    tint = bodyColor
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = formattedDate,
                    style = MaterialTheme.typography.labelSmall,
                    color = bodyColor
                )
            }
        }
    }
}