# BBCAnalyzer System

The BBCAnalyzer System is an innovative and user-friendly web application designed to assist editors, publishers, and readers in classifying news into five categories: business, entertainment, politics, sport, and tech. Leveraging state-of-the-art Keras models, the application accurately categorizes news articles, providing vital information to users. The system is built using powerful machine learning technologies such as scikit-learn, Keras, and TensorFlow, and is implemented in Python.

## Features

* **State-of-the-Art Model**: Utilizes advanced Keras models for accurate classification of news articles into five categories.
* **User-Friendly Interface**: A clean and intuitive interface for easy news classification.
* **Real-Time Results**: Provides immediate feedback on the category of the news article.
* **Editor and Publisher Friendly**: Designed to help editors and publishers streamline the categorization process and improve content management.
* **Reader-Friendly Solution**: Enables readers to quickly find news based on their topics of interest.

## Technologies Used

* **scikit-learn**: For data preprocessing and feature extraction.
* **Keras/TensorFlow**: Model building for news classification.
* **Python**: Core logic and implementation of the application.

## How It Works

### Model Deployment
1. **Model Training**: The Keras model is trained using a dataset of labeled news articles.
2. **News Processing**: The service processes the input news article and performs inference using the trained model.
3. **Result Communication**: The service returns the classification result to the user interface for display.

## Model Performance

The performance of the model is evaluated using various metrics to ensure its accuracy and reliability. The table below presents the performance metrics:

| Metric      | Value   |
|-------------|---------|
| Accuracy    | 95.2%     |
| AUC         | 0.97    |
| F1 Score    | 0.93    |

## Setup

### Model Training and Deployment

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/hungrycarpet/Machine-Learning-Deep-Learning-Projects.git
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd BBCAnalyzer
    ```

3. **Set up the Environment**:
    ```bash
    pip install -r requirements.txt
    ```

4. **Train the Model**:
    Run the training script to train the Keras model on the news dataset.

5. **Deploy the Model**:
    Implement the model inference script to classify news articles.

## Contact

For any queries or feedback, please contact me at ***manasparasar@gmail.com***

## License

MIT License
