export interface iHotel {
  id: string;
  type: string;
  name: string;
  thumbnailUrl: string;
  created: number;
  modified: number;
  address1: string;
  airportCode: string;
  amenityMask: number;
  city: string;
  confidenceRating: number;
  countryCode: string;
  deepLink: string;
  highRate: number;
  hotelId: number;
  hotelInDestination: boolean;
  hotelRating: number;
  location: {
    latitude: number;
    longitude: number;
  };
  locationDescription: string;
  lowRate: number;
  metadata: {
    path: string;
  };
  postalCode: number;
  propertyCategory: number;
  proximityDistance: number;
  proximityUnit: string;
  rateCurrencyCode: string;
  shortDescription: string;
  stateProvinceCode: string;
  images: string[];
  thumbNailUrl: string;
  tripAdvisorRating: number;
  tripAdvisorRatingUrl: string;
}

