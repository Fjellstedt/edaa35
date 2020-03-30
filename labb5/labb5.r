
source("R_resources.r")

# function for plotting data
plotresult <- function ( file , start = 1) {
data <- read.csv( file )
data <- data[start:nrow(data),]
plot(data, type='l')
data
}

generatePlots <- function() {

totalData <- vector()
for(val in 1:10)
{
system("java Labb data1.txt result1_10.txt 600")
newData = plotresult("result1_10.txt",15)
newData <- mean(newData[15:600,2])
totalData = cbind(totalData, newData)
}
 
write.csv(mean(normalizedData), file="mean.txt")
write.csv(confidenceInterval(normalizedData), file="conf.txt")

pdf("result1_10.pdf")
plotresult("result1_10.txt",15) # plot to pdf file
dev.off ()

}

ttestBetweenFiles <- function(){

data3 <- read.csv("result3_2_100.txt")
data1 <- read.csv("result1_2_100.txt")

t.test(data3, data1)

}
