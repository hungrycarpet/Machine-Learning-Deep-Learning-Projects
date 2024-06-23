# Quackdet Tremor Detection System

The Quackdet Tremor Detection System is an innovative and user-friendly mobile application designed to forecast possible tremors for a given location using real-time data from the USGS website. Leveraging state-of-the-art AI models, the system accurately predicts tremor activity, providing vital information to users. The project is divided into two parts: the AI model development, which includes data preprocessing, model training, and fine-tuning, and the mobile application built using stock Android. The model is deployed on-device and fed with data from the USGS for a location inputted by the user.

## Features

* **State-of-the-Art Model**: Utilizes advanced AI models for accurate tremor forecasting.
* **User-Friendly Interface**: A clean and intuitive Android interface for real-time tremor monitoring and forecasting.
* **On-Device Deployment**: The model is deployed on-device, ensuring high availability and quick response times.
* **Real-Time Data**: Integrates real-time tremor data from the USGS for accurate and timely predictions.
* **Life-Saving Solution**: Designed to help users prepare for potential tremor activity, reducing risk and enhancing safety.

## Technologies Used

* **sklearn**: Used for data preprocessing and model training.
* **Keras/TensorFlow**: Model building for tremor forecasting.
* **Python**: Core logic for AI model development.
* **Android**: Mobile application development for user interaction.
* **XML**: Layout design for the Android application.
* **Java**: Backend logic for the Android application.

## How It Works

### User Interface
1. **Location Input**: Users can input their location through the Android interface.
2. **Tremor Detection**: The application queries the on-device model to forecast tremor activity.
3. **Result Display**: The application displays real-time tremor data and forecast results.

### AI Model
1. **Data Preprocessing**: Raw data from the USGS is cleaned and prepared for model training.
2. **Model Training**: The AI model is trained using historical tremor data.
3. **Model Deployment**: The trained model is deployed on the Android device.

## Model Performance

The performance of the model is evaluated using various metrics to ensure its accuracy and reliability. The table below presents the performance metrics:

| Metric      | Value   |
|-------------|---------|
| Mean Squared Error    | 0.1705 |
| Mean Absolute Error   | 0.3027   |

## Setup

### AI Model

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/hungrycarpet/Machine-Learning-Deep-Learning-Projects.git
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd Quackdet-Tremor-Detection
    ```

3. **Set up the Environment**:
    ```bash
    pip install -r requirements.txt
    ```

2. **Navigate to the Ai Model Work Directory**:
    ```bash
    cd ai model work
    ```

4. **Train the Model**:
    Run the provided ```bash tremor_forcast_model_work``` scripts to preprocess data and train the model.

### Android Application

1. **Open in Android Studio**:
    Open the `Quackdet-Tremor-Detection/android app work/` directory in Android Studio.

2. **Build the Project**:
    Sync the project with Gradle files and build the project.

3. **Install on Device**:
    Deploy the application on your Android device.

## Project Structure

* `model/`: Contains all the source code and data for AI model development.
* `android/`: Contains the Android application code and resources.
* `requirements.txt`: Lists the dependencies for the AI model.

## Mobile App Screenshots

![Menu of App](android%20app%20work/1.jpg)

![ Drawer](android%20app%20work/2.jpg)

![About 1](android%20app%20work/3.jpg)

![About 2](android%20app%20work/4.jpg)

![About 2](android%20app%20work/5.jpg)

## Contact

For any queries or feedback, please contact me at ***manasparasar@gmail.com***

## License

MIT License

Copyright (c) 2019 Manas Mishra

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
