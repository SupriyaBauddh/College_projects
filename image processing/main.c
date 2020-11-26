#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define BMP_HEADER_SIZE        54
#define BMP_COLOR_TABLE_SIZE   1024
#define CUSTOM_IMG_SIZE        1024*1024
#define WHITE 255
#define BLACK 0
#define THRESHOLD 150
#define MAX_COLOR 255
#define MIN_COLOR 0
#define PI 3.14
#define MAX_PIXEL 255

void imageSepia();

int meanGrey();

void ImageMorphing();

void imageNeagtive();

void ChangeDetection();

void imageTranslate();

void writeImage(const char *imgName,
                unsigned char *header,
                unsigned char *colortable,
                unsigned char *buff,
                int bitdepth);

void readImage(const char *imgName,
               int *height,
               int *width,
               int *bitdepth,
               unsigned char *header,
               unsigned char *colortable,
               unsigned char *buff
               );

void getImageDetail(int noRows,
                    int noCols,
                    int maxVal
                    );

void colorToGray(const char *imgName,
                 const char *greyImg,
                 unsigned char *header,
                 unsigned char *colortable,
                 int bitdepth,
                 int height,
                 int width
                 );

void greyToBinary(const char *greyImg,
                  const char *bwImg,
                  unsigned char *header,
                  unsigned char *colortable,
                  int height,
                  int width,
                  int bitdepth);

void imageRotate();

void enlarge();

void shrink();

void cropImage(int LRow,int URow,int LCol,int UCol);

void reflectImage(int flag);

void imageBlur();

void getPixelVal(int r,int c);

void setPixelVal(int r,int c);

int main()
{
    int width,height,bitdepth;
    unsigned char header[BMP_HEADER_SIZE];
    unsigned char colortable[BMP_COLOR_TABLE_SIZE];
    unsigned char buff[CUSTOM_IMG_SIZE];

    const char imgName[]="C:/Users/ABHISHEK/Desktop/images/lena_color.bmp";
    const char newimgName[]="C:/Users/ABHISHEK/Desktop/images/lena_copy.bmp";
    const char greyImg[]="C:/Users/ABHISHEK/Desktop/images/lena_grey.bmp";
    const char greyImg1[]="C:/Users/ABHISHEK/Desktop/images/lighthouse.bmp";
    const char bwImg[]="C:/Users/ABHISHEK/Desktop/images/lighthouse_bw.bmp";

    readImage(imgName,&height,&width,&bitdepth,header,colortable,buff);
    printf("SUCCESSFULLY READ IMAGE ! \n\n");

    int choice;
    printf("1. CONVERT INTO GREY\n2. BINARIZATION\n3. IMAGE MORPHING (ADDITION)\n");
    printf("4. CHANGE DETECTION (SUBTRACTION)\n5. ROTATION OF IMAGE");
    printf("\n6. IMAGE ENLARGEMENT\n7. IMAGE SHRINKING");
    printf("\n8. CROP IMAGE\n9. REFLECTION OF IMAGE\n");
    printf("10. DETAILS OF IMAGE\n11. COPY IMAGE\n");
    printf("12. IMAGE TRANSLATION\n13. NEGATIVE OF  IMAGE\n");
    printf("14. IMAGE ENHANCEMENT FILTERS\n15. GET PIXEL VALUE AT (r,c)\n");
    printf("16. SET PIXEL VALUE AT (r,c)\n17. AVERAGE GREY VALUE OF IMAGE\n");

    printf("ENTER THE NO OF FUNCTION YOU WANT TO PERFORM : ");
    scanf("%d",&choice);

    int flag,r,c;
    int LRow,URow,LCol,UCol;

    switch(choice)
    {
    case 1 :
        colorToGray(imgName,greyImg,header,colortable,bitdepth,height,width);
        printf("SUCCESSFULLY CONVERTED TO GREY COLOR ! \n");
        break;

    case 2 :
        readImage(greyImg1,&height,&width,&bitdepth,header,colortable,buff);
        greyToBinary(greyImg1,bwImg,header,colortable,height,width,bitdepth);
        printf("SUCCESSFULLY BINARIZED IMAGE ! \n");
        break;

    case 3 :
        ImageMorphing();
        printf("IMAGE ADDITION SUCCESSFUL ! \n");
        break;

    case 4 :
        ChangeDetection();
        printf("IMAGE SUBTRACTION SUCCESSFUL ! \n");
        break;

    case 5 :
        imageRotate();
        break;

    case 6 :
        enlarge();
        break;

    case 7 :
        shrink();
        break;

    case 8 :
        printf("ENTER LOWER ROW : ");
        scanf("%d",&LRow);
        printf("ENTER UPPER ROW : ");
        scanf("%d",&URow);
        printf("ENTER LOWER COLUMN : ");
        scanf("%d",&LCol);
        printf("ENTER UPPER COLUMN : ");
        scanf("%d",&UCol);
        cropImage(LRow,URow,LCol,UCol);
        break;

    case 9 :
        printf("Horizontal Reflection = '0' & Vertical Reflection = '1' -> ");
        scanf("%d",&flag);
        reflectImage(flag);
        break;

    case 10 :
        getImageDetail(0,0,0);
        break;

    case 11 :
        writeImage(newimgName,header,colortable,buff,bitdepth);
        printf("SUCCESSFULLY WRITE COPY OF IMAGE ! \n");
        break;

    case 12 :
        imageTranslate();
        break;

    case  13 :
        imageNeagtive();
        break;

    case 14 :
        printf("BLUR = 1 & SEPIA = 2 : ");
        scanf("%d",&flag);
        if(flag==1)
            imageBlur();
        if(flag==2)
            imageSepia();
        break;

    case 15 :
        printf("\nEnter value of row and column (both less than 512) : ");
        scanf("%d%d",&r,&c);
        getPixelVal(r,c);
        break;

    case 16 :
        printf("\nEnter value of row and column : ");
        scanf("%d%d",&r,&c);
        setPixelVal(r,c);
        break;

    case 17 :
        flag=meanGrey();
        printf("\nAverage Grey Value Of Image : %d\n",flag);
        break;

    }

    return 0;
}

void setPixelVal(int r,int c)
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lena512.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/lena_pixel_set.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int*)&header[22];
    int width=*(int*)&header[18];
    int bitdepth=*(int*)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),height * width,fin);

    int t;
    printf("enter new value of the pixel (0 <= t <=255) : ");
    scanf("%d",&t);

    buffIn[r][c]=t;

    for(int i=0;i<width;i++)
        for(int j=0;j<height;j++)
            buffOut[i][j]=buffIn[i][j];

    fwrite(buffOut,sizeof(unsigned char),height * width,fout);

    fclose(fin);
    fclose(fout);
}
void getPixelVal(int r,int c)
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lena512.bmp","rb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    int height=*(int*)&header[22];
    int width=*(int*)&header[18];
    int bitdepth=*(int*)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
    }

    unsigned char buffIn[width][height];

    for(int i=0;i<width;i++)
        for(int j=0;j<height;j++)
            buffIn[i][j]=getc(fin);

    printf("pixel value at (%d,%d) : %d",r,c,buffIn[r][c]);

    fclose(fin);
}

void imageTranslate()
{
    FILE *fIn= fopen("C:/Users/ABHISHEK/Desktop/images/cameraman.bmp","rb");
    FILE *fOut =fopen("C:/Users/ABHISHEK/Desktop/images/cameraman_translate.bmp","wb");
    int selected;

    unsigned char imgHeder[54];
    unsigned char colorTable[1024];

    if(fIn == NULL)
    {
        printf("Unable to open file\n");
    }

    for(int i =0;i<54;i++)
    {
        imgHeder[i] = getc(fIn);
    }
    fwrite(imgHeder,sizeof(unsigned char),54,fOut);
    int height = *(int*)&imgHeder[22];
    int width  =  *(int *)&imgHeder[18];
    int bitDepth = *(int *)&imgHeder[28];

    if(bitDepth <=8)
    {
        fread(colorTable,sizeof(unsigned char),1024,fIn);
        fwrite(colorTable,sizeof(unsigned char),1024,fOut);
    }

    int imgSize = height * width;

    unsigned char buffer[width][height];
    unsigned char out_buffer[width][height];

    fread(buffer,sizeof(unsigned char),imgSize,fIn);
    int t;
    printf("Amount of translation in X direction : ");
    scanf("%d",&t) ;

    for(int x =0;x<width;x++)
    {
        for(int y =0;y<height;y++)
        {
            if((y+t)<512)
                out_buffer[x][y+t] = buffer[x][y];
            else
                out_buffer[x][512-(y+t)]=buffer[x][y];
        }
    }

    fwrite(out_buffer,sizeof(unsigned char),imgSize,fOut);

    printf("SUCCESSFULY TRANSLATED IMAGE !\n");

    fclose(fIn);
    fclose(fOut);
}

void readImage(const char *imgName,
               int *height,
               int *width,
               int *bitdepth,
               unsigned char *header,
               unsigned char *colortable,
               unsigned char *buff
               )
{
    int i;
    FILE *read;
    read=fopen(imgName,"rb");

    if(read==(FILE *)0)
        printf("UNABLE TO READ IMAGE \n");

    for(i=0;i<54;i++)
        header[i]=getc(read);

    *width=*(int *)&header[18];
    *height=*(int *)&header[22];
    *bitdepth=*(int *)&header[28];

    if(*bitdepth<=8)
        fread(colortable,sizeof(unsigned char),1024,read);

    fread(buff,sizeof(unsigned char),CUSTOM_IMG_SIZE,read);

    fclose(read);
}

void writeImage(const char *imgName,
                unsigned char *header,
                unsigned char *colortable,
                unsigned char *buff,
                int bitdepth)
{
    FILE *write=fopen(imgName,"wb");

    fwrite(header,sizeof(unsigned char),54,write);

    if(bitdepth<=8)
        fwrite(colortable,sizeof(unsigned char),1024,write);

    fwrite(buff,sizeof(unsigned char),CUSTOM_IMG_SIZE,write);

    fclose(write);
}

void getImageDetail(int noRows,
                    int noCols,
                    int maxVal
                    )
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/girlface.bmp","rb");

    unsigned char header[54];

    if(fin==(FILE *)0)
        printf("UNABLE TO READ IMAGE \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    noCols=*(int *)&header[18];
    noRows=*(int *)&header[22];
    int bitdepth=*(int *)&header[28];

    int imgSize=noCols * noRows;

    unsigned char buff[noCols][noRows];

    fread(buff,sizeof(unsigned char),imgSize,fin);

    maxVal=buff[0][0];

    for(int i=0;i<noCols;i++)
        for(int j=0;j<noRows;j++)
        {
            if((int)buff[i][j] > maxVal)
                maxVal=(int)buff[i][j];
        }

    printf("No of rows : %d\nNo of columns : %d\nMax Value of pixel : %d\n\n",noRows,noCols,maxVal);
}

void colorToGray(const char *imgName,
                 const char *greyImg,
                 unsigned char *header,
                 unsigned char *colortable,
                 int bitdepth,
                 int height,
                 int width
                 )
{
    FILE *fin=fopen(imgName,"rb");
    FILE *fout=fopen(greyImg,"wb");

    fwrite(header,sizeof(unsigned char),54,fout);

    if(bitdepth<=8)
        fwrite(colortable,sizeof(unsigned char),1024,fout);

    int imgSize=height * width;
    unsigned char buffer[imgSize][3];

    for(int i=0;i<imgSize;i++)
    {
        buffer[i][0]=getc(fin);  //red
        buffer[i][1]=getc(fin);  //green
        buffer[i][2]=getc(fin);  //blue
        int temp=0;
        temp=(buffer[i][0]*0.3)+(buffer[i][1]*0.59)+(buffer[i][2]*0.11);
        putc(temp,fout);
        putc(temp,fout);
        putc(temp,fout);
    }

    fclose(fin);
    fclose(fout);
}

void greyToBinary(const char *greyImg,
                  const char *bwImg,
                  unsigned char *header,
                  unsigned char *colortable,
                  int height,
                  int width,
                  int bitdepth
                  )
{
    FILE *fin=fopen(greyImg,"rb");
    FILE *fout=fopen(bwImg,"wb");

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    fwrite(header,sizeof(unsigned char),54,fout);

    int imgSize=height * width;

    if(bitdepth<=8)
        fwrite(colortable,sizeof(unsigned char),1024,fout);

    unsigned char buffer[imgSize];
    fread(buffer,sizeof(unsigned char),imgSize,fin);

    //BLACK AND WHITE CONERTOR
    for(int i=0;i<imgSize;i++)
    {
        buffer[i] = (buffer[i]>THRESHOLD) ? WHITE : BLACK;
    }

    fwrite(buffer,sizeof(unsigned char),imgSize,fout);

    fclose(fin);
    fclose(fout);

}

void ImageMorphing()
{
    FILE *fin1=fopen("C:/Users/ABHISHEK/Desktop/images/lena512.bmp","rb");
    FILE *fin2=fopen("C:/Users/ABHISHEK/Desktop/images/bridge.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/img_add.bmp","wb");

    int i;
    unsigned char header1[BMP_HEADER_SIZE];
    unsigned char colortable1[BMP_COLOR_TABLE_SIZE];

    unsigned char header2[BMP_HEADER_SIZE];
    unsigned char colortable2[BMP_COLOR_TABLE_SIZE];

    if(fin1==NULL)
        printf("UNABLE TO OPEN FIRST IMAGE ! \n");

    for(i=0;i<54;i++)
        header1[i]=getc(fin1);

    fwrite(header1,sizeof(unsigned char),54,fout);

    int width1=*(int *)&header1[18];
    int height1=*(int *)&header1[22];
    int bitdepth1=*(int *)&header1[28];

    if(bitdepth1<=8)
    {
        fread(colortable1,sizeof(unsigned char),1024,fin1);
        fwrite(colortable1,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height1 * width1;
    unsigned char buff1[imgSize];
    fread(buff1,sizeof(unsigned char),imgSize,fin1);

    if(fin2==NULL)
        printf("UNABLE TO OPEN SECOND IMAGE ! \n");

    for(i=0;i<54;i++)
        header2[i]=getc(fin2);

    int width2=*(int *)&header2[18];
    int height2=*(int *)&header2[22];
    int bitdepth2=*(int *)&header2[28];

    if(bitdepth2<=8)
        fread(colortable2,sizeof(unsigned char),1024,fin2);

    unsigned char buff2[imgSize];
    fread(buff2,sizeof(unsigned char),imgSize,fin2);

    int temp;

    //IMAGE ADDITION PERFORMED
    for(i=0;i<imgSize;i++)
    {
        temp=buff1[i]+buff2[i];
        buff1[i] = (temp > MAX_COLOR) ? MAX_COLOR : temp;
    }

    fwrite(buff1,sizeof(unsigned char),imgSize,fout);

    fclose(fin1);
    fclose(fin2);
    fclose(fout);

}

void ChangeDetection()
{
    FILE *fin1=fopen("C:/Users/ABHISHEK/Desktop/images/lena512.bmp","rb");
    FILE *fin2=fopen("C:/Users/ABHISHEK/Desktop/images/bridge.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/img_subtract.bmp","wb");

    int i;
    unsigned char header1[BMP_HEADER_SIZE];
    unsigned char colortable1[BMP_COLOR_TABLE_SIZE];

    unsigned char header2[BMP_HEADER_SIZE];
    unsigned char colortable2[BMP_COLOR_TABLE_SIZE];

    if(fin1==NULL)
        printf("UNABLE TO OPEN FIRST IMAGE ! \n");

    for(i=0;i<54;i++)
        header1[i]=getc(fin1);

    fwrite(header1,sizeof(unsigned char),54,fout);

    int width1=*(int *)&header1[18];
    int height1=*(int *)&header1[22];
    int bitdepth1=*(int *)&header1[28];

    if(bitdepth1<=8)
    {
        fread(colortable1,sizeof(unsigned char),1024,fin1);
        fwrite(colortable1,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height1 * width1;
    unsigned char buff1[imgSize];
    fread(buff1,sizeof(unsigned char),imgSize,fin1);

    if(fin2==NULL)
        printf("UNABLE TO OPEN SECOND IMAGE ! \n");

    for(i=0;i<54;i++)
        header2[i]=getc(fin2);

    int width2=*(int *)&header2[18];
    int height2=*(int *)&header2[22];
    int bitdepth2=*(int *)&header2[28];

    if(bitdepth2<=8)
        fread(colortable2,sizeof(unsigned char),1024,fin2);

    unsigned char buff2[imgSize];
    fread(buff2,sizeof(unsigned char),imgSize,fin2);

    int temp;

    //IMAGE SUBTRACTION PERFORMED
    for(i=0;i<imgSize;i++)
    {
        temp=buff1[i]-buff2[i];
        buff1[i] = (temp < MIN_COLOR) ? ((-1)*temp) : temp;
    }

    fwrite(buff1,sizeof(unsigned char),imgSize,fout);

    fclose(fin1);
    fclose(fin2);
    fclose(fout);

}

void imageRotate()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse_rotate.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int angle;
    printf("\nEnter the angle of rotation in degrees (+ve value) : ");
    scanf("%d",&angle);
    int ch;
    printf("for anticlockwise rotation press 1 & for clockwise rotation press 2 : ");
    scanf("%d",&ch);

    double cosine=cos(angle*(PI/180));
    double sine=sin(angle*(PI/180));

    for(int i=0;i<width;i++)
    {
        for(int j=0;j<height;j++)
        {
            int a=(cosine*i)+(sine*j);
            int b=(-1*sine*i)+(cosine*j);
            if(ch==2)
                buffOut[i][j]=buffIn[a][b];
            else
                buffOut[a][b]=buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("SUCCESSFULLY ROTATED IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void enlarge()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/cameraman.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/cameraman_enlarge.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int x;
    printf("\nEnter the factor of enalargement : ");
    scanf("%d",&x);

    for(int i=0;i<width;i++)
    {
        for(int j=0;j<height;j++)
        {
            buffOut[i*x][j*x]=buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("SUCCESSFULLY ENLARGED IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void shrink()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/cameraman.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/cameraman_shrink.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int x;
    printf("\nEnter the factor of shrinking : ");
    scanf("%d",&x);

    for(int i=0;i<width;i++)
    {
        for(int j=0;j<height;j++)
        {
            buffOut[i/x][j/x]=buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("SUCCESSFULLY SHRINKED IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void cropImage(int LRow,int URow,int LCol,int UCol)
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse_crop.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    for(int i=LCol;i<=UCol;i++)
    {
        for(int j=LRow;j<=URow;j++)
        {
            buffOut[i][j]=buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("\n SUCCESSFULLY CROPPED IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void reflectImage(int flag)
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse_reflect.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int a,b,i,j;
    for(i=0;i<width;i++)
    {
        for(j=0;j<height;j++)
        {
            if(flag==1)
                buffOut[height-i][j]=buffIn[i][j];
            if(flag==0)
                buffOut[i][height-j]=buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("\n SUCCESSFULLY REFLECTED IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void imageNeagtive()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/girlface.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/girlface_negative.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];
    unsigned char buffOut[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int i,j;
    for(i=0;i<width;i++)
    {
        for(j=0;j<height;j++)
        {
            buffOut[i][j]=255-buffIn[i][j];
        }
    }

    fwrite(buffOut,sizeof(unsigned char),imgSize,fout);

    printf("\n SUCCESSFULLY MADE NEGATIVE OF IMAGE ! \n");

    fclose(fin);
    fclose(fout);
}

void imageBlur()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/fruits.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/fruits_blur.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int*)&header[22];
    int width=*(int*)&header[18];
    int bitdepth=*(int*)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[imgSize][3];
    unsigned char buffOut[imgSize][3];

    for(int i=0;i<imgSize;i++)
    {
        buffIn[i][2]=getc(fin);
        buffIn[i][1]=getc(fin);
        buffIn[i][0]=getc(fin);
    }

    float kernel[3][3]={{1.0/9.0,1.0/9.0,1.0/9.0},
                        {1.0/9.0,1.0/9.0,1.0/9.0},
                        {1.0/9.0,1.0/9.0,1.0/9.0}};

    for(int x=1;x<height-1;x++)
    {
        for(int y=1;y<width-1;y++)
        {
            float sum0=0.0;
            float sum1=0.0;
            float sum2=0.0;

            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    sum0 = sum0 + (float)kernel[i+1][j+1] * buffIn[(x+i)*width+(y+j)][0];
                    sum1 = sum1 + (float)kernel[i+1][j+1] * buffIn[(x+i)*width+(y+j)][1];
                    sum2 = sum2 + (float)kernel[i+1][j+1] * buffIn[(x+i)*width+(y+j)][2];
                }
            }

            buffOut[(x)*width+(y)][0] = sum0;
            buffOut[(x)*width+(y)][1] = sum1;
            buffOut[(x)*width+(y)][2] = sum2;

        }
    }

    for(int i=0;i<imgSize;i++)
    {
        putc(buffOut[i][2],fout);
        putc(buffOut[i][1],fout);
        putc(buffOut[i][0],fout);
    }

    fclose(fin);
    fclose(fout);

    printf("SUCCESSFULLY BLURRED IMAGE ! \n");
}

void imageSepia()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lena_color.bmp","rb");
    FILE *fout=fopen("C:/Users/ABHISHEK/Desktop/images/lena_sepia.bmp","wb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    fwrite(header,sizeof(unsigned char),54,fout);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
        fwrite(colortable,sizeof(unsigned char),1024,fout);
    }

    int imgSize=height * width;

    unsigned char buffIn[imgSize][3];

    int r,g,b;

    for(int i=0;i<imgSize;i++)
    {
        r=g=b=0;
        buffIn[i][0]=getc(fin);  //red
        buffIn[i][1]=getc(fin);  //green
        buffIn[i][2]=getc(fin);  //blue

        r=(buffIn[i][0]*0.393) + (buffIn[i][1]*0.769) + (buffIn[i][2]*0.189);
        g=(buffIn[i][0]*0.349) + (buffIn[i][1]*0.686) + (buffIn[i][2]*0.168);
        b=(buffIn[i][0]*0.372) + (buffIn[i][1]*0.534) + (buffIn[i][2]*0.131);

        if(r>MAX_PIXEL)
            r=MAX_PIXEL;
        if(g>MAX_PIXEL)
            g=MAX_PIXEL;
        if(b>MAX_PIXEL)
            b=MAX_PIXEL;

        putc(b,fout);
        putc(g,fout);
        putc(r,fout);

    }

    printf("IMAGE ENHANCED TO SEPIA ! \n");

    fclose(fin);
    fclose(fout);
}

int meanGrey()
{
    FILE *fin=fopen("C:/Users/ABHISHEK/Desktop/images/lighthouse.bmp","rb");

    unsigned char header[54];
    unsigned char colortable[1024];

    if(fin==NULL)
        printf("UNABLE TO OPEN IMAGE ! \n");

    for(int i=0;i<54;i++)
        header[i]=getc(fin);

    int height=*(int *)&header[22];
    int width=*(int *)&header[18];
    int bitdepth=*(int *)&header[28];

    if(bitdepth<=8)
    {
        fread(colortable,sizeof(unsigned char),1024,fin);
    }

    int imgSize=height * width;

    unsigned char buffIn[width][height];

    fread(buffIn,sizeof(unsigned char),imgSize,fin);

    int sum=0.0;

    for(int i=0;i<width;i++)
    {
        for(int j=0;j<height;j++)
        {
            sum = sum + (int)buffIn[i][j];
        }
    }

    fclose(fin);

    return (sum/imgSize);
}






