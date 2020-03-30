# Only here to make it easier to use, should not be here.
data2a <- read.csv("data.txt")

removeNA <- function(data) {
	#na.omit(takes data frame) ret: data frame utan na
	return (data[complete.cases(data),])
}

analysePotentialOutliers <- function(data, threshold){
	result <- matrix(, nrow = length(threshold), ncol = 3)
	for(v in 1:length(threshold)) {
		nonOutliers <- vector()
		for(index in 1:nrow(data)) {
			value <- data[index, v]
			if(value <= threshold[v]) {
				nonOutliers <- c(nonOutliers, value)
			}
		}
		result[v,1] <- paste("variable", v)
		result[v,2] <- length(data[, v]) - length(nonOutliers)
		result[v,3] <- mean(nonOutliers)
	}
	colnames(result) <- c("Variable", "NrPotentialOutliers", "MeanNoOutliers")
	print(result)
}