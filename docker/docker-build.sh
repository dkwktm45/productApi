# Setting versions
VERSION='1.0.1'

cd ..
./gradlew clean build -x test

ROOT_PATH=`pwd`
echo $ROOT_PATH

echo 'api docker image build..'
cd $ROOT_PATH/product-api && docker build -t product:$VERSION .

echo 'consumer docker image build..'
cd $ROOT_PATH/user-api && docker build -t user:$VERSION .