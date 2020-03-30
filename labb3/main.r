# Only here to make it easier to use, should not be here.
data <- read.csv("data.txt", col.names = c("labb", "est", "act"))

dataA <- subset(data[data$labb=="A",,], select = c("est", "act"))
dataB <- subset(data[data$labb=="B",,], select = c("est", "act"))
#boxplot(sort(table(data$labb), decreasing=T))

