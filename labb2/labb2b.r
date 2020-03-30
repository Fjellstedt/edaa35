
contributors <- function(file, n){
	#Load file, show stapel diagram of the n most users, ordered descending from left, use barplot.
	data2b <- read.csv(file, sep='|', stringsAsFactors=F, col.names = c("rev", "names", "dates", "lines"))
	barplot(sort(table(data2b$names), decreasing=T)[1:n])
	#Return vector sorted by commit dates where every element is named by the user.
	dups <- !duplicated(data2b$names)
	result <- substring(data2b$dates[dups], first=2, last=11)
	names(result) <- data2b$names[dups]
	rev(result)
}